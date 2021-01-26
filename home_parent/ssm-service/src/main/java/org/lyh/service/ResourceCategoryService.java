package org.lyh.service;

import org.lyh.bean.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    // 查询所有资源
    List<ResourceCategory> findAllResourceCategory();
}
