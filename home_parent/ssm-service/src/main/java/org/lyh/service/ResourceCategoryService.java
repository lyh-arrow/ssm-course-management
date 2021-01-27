package org.lyh.service;

import org.lyh.bean.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    // 查询所有资源
    List<ResourceCategory> findAllResourceCategory();

    //添加资源
    void saveResourceCategory(ResourceCategory resourceCategory);

    //更新资源
    void updateResourceCategory(ResourceCategory resourceCategory);

    //删除资源分类
    void deleteResourceCategory(Integer id);
}
