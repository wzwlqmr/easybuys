package com.mr.easybuy.wares.util.es;

import com.mr.easybuy.wares.entity.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductESRepository
//        extends ElasticsearchCrudRepository<ProductVO,String>
{

    /*/**
    * @Description: findBanksVOById
    * @Param: []
    * @return: com.mr.model_demo.entity.BanksVO
    * @Author: yxy
    * @Date: 2019/10/17
    */
    public ProductVO queryProductVOById(String id);
    
    /*/** 
    * @Description: queryProductVOByName 
    * @Param: [name]
    * @return: com.mr.model_demo.entity.ProductVO 
    * @Author: yxy 
    * @Date: 2019/10/17 
    */
    public List<ProductVO> queryProductVOByName(String name);

    /*/**
     * @Description: queryProductVOByName
     * @Param: [name]
     * @return: com.mr.model_demo.entity.ProductVO
     * @Author: yxy
     * @Date: 2019/10/17
     */
    public List<ProductVO> queryProductVOByNameAndAge(String name, Integer age);

}
