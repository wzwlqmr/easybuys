package com.mr.easybuy.wares.util.es;

import org.elasticsearch.action.index.IndexRequest;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class EsUtils {

    public void createIndexInfo(String index,String type,String id){
        IndexRequest indexRequest = new IndexRequest(index,type,id)
                .source(
                        "user","",
                        "postDate",new Date(),
                        "message","trying out Elasticsearch"
                );
    }

}
