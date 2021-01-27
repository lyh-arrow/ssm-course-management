package org.lyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lyh.bean.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    //查询所有资源分类
    @Select("select * from resource_category")
    List<ResourceCategory> findAllResourceCategory();

    //添加资源分类
    @Insert("insert into resource_category values (null,#{name},#{sort},#{createdTime},#{updatedTime},#{createdBy},#{updatedBy})")
    void saveResourceCategory(ResourceCategory resourceCategory);

    //更新资源分类
    @Update("update resource_category set name=#{name},sort=#{sort},updated_time=#{updatedTime},updated_by=#{updatedBy} where id=#{id}")
    void updateResourceCategory(ResourceCategory resourceCategory);

    //删除资源分类
    @Delete("delete from resource_category where id=#{id}")
    void deleteResourceCategory(Integer id);
}
