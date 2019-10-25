package com.mr.easybuy.wares.service;

import com.mr.easybuy.wares.entity.Tree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface ITypeService {

    List<Tree> findTypeList(HttpServletRequest request);

}
