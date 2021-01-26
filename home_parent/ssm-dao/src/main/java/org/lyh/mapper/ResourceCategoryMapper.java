package org.lyh.mapper;

import org.apache.ibatis.annotations.Select;
import org.lyh.bean.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    //查询所有资源分类
    @Select("select * from resource_category")
    List<ResourceCategory> findAllResourceCategory();
}
