package com.mr.easybuy.wares.service.impl;

import com.mr.easybuy.wares.mapper.TypesMapper;
import com.mr.easybuy.wares.service.ITypeService;
import com.mr.easybuy.wares.util.redis.RedisUtil;
import com.mr.easybuy.wares.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypesMapper typesMapper;

      @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Tree> findTypeList(HttpServletRequest request) {

        List<Tree> menuList = typesMapper.findAuthList();
        List<Tree> treeList=getTree(menuList,"0");
        return treeList;

    }


    public List<Tree> getTree(List<Tree> list,String pid){
        List<Tree> newList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPid().equals(pid)){
                List<Tree> tempList = getTree(list,list.get(i).getId());
                list.get(i).setChildren(tempList);
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
