package com.mr.easybuy.wares.util.es;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.elasticsearch.search.sort.SortOrder;
import java.util.Iterator;
import java.util.Map;


@Repository
public class EsUtilss {
    @Autowired
    private RestHighLevelClient highClient;

    public void testIt(String index){
        //创建查询request
        SearchRequest sr= new SearchRequest(index);
        //创建查询条件
        SearchSourceBuilder ssb=new SearchSourceBuilder();

        ssb.query(QueryBuilders.matchAllQuery());
        ssb.sort("postDate", SortOrder.DESC);
        ssb.from(0);
        ssb.size(2);
        sr.source(ssb);
        try {
            SearchResponse search = highClient.search(sr, RequestOptions.DEFAULT);
            System.out.println(search);
            Iterator<SearchHit> iterator = search.getHits().iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().getSourceAsString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public String findByGet(Map<String,String> indexMap, String[] includes, String[] excludes){

        GetRequest gr = new GetRequest(indexMap.get("index"), indexMap.get("type"), indexMap.get("id"));

        FetchSourceContext fsc = new FetchSourceContext(true,includes,excludes);

        gr.fetchSourceContext(fsc);

        try {
            GetResponse documentFields = highClient.get(gr, RequestOptions.DEFAULT);
            System.out.println(documentFields.getSource().toString());

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    // 删除数据内容
    public void deleIndex(Map<String,String> map){
        DeleteRequest deleteRequest = new DeleteRequest(map.get("index"), map.get("type"), map.get("id"));
        try{
            DeleteResponse delete = highClient.delete(deleteRequest, RequestOptions.DEFAULT);
            System.out.println(delete);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addIndexByAsyn(String param,Map<String,String> indexMap){
        // 构建一个用于添加的对象
        // 创建一个request请求  用来往ES中写入内容
        // 参数分别有索引  类型 以及 id
        // 具体的内容放置在source里面
        IndexRequest indexRequest = new IndexRequest(indexMap.get("index"), indexMap.get("type"), indexMap.get("id"))
                .source(param, XContentType.JSON);
        try {
            // 创建一个回调信息
            ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>() {
                @Override
                public void onResponse(IndexResponse indexResponse) {
                    System.out.println("回调成功");
                    System.out.println(indexResponse);
                }
                @Override
                public void onFailure(Exception e) {
                    System.out.println("回调失败");
                }
            };
            // 通过client进行请求的发送
            highClient.indexAsync(indexRequest, RequestOptions.DEFAULT,listener);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
