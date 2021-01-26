package org.lyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lyh.bean.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    //查询所有广告位
    @Select("select * from promotion_space")
    List<PromotionSpace> findAllPromotionSpace();

    //添加广告位
    @Insert("insert into promotion_space values(null,#{name},#{spaceKey},#{createTime},#{updateTime},#{isDel})")
    void savePromotionSpace(PromotionSpace promotionSpace);

    //根据id查询广告位信息
    @Select("select id,name from promotion_space where id = #{id}")
    PromotionSpace findPromotionSpaceById(Integer id);

    //修改广告位
    @Update("update promotion_space set name=#{name},updateTime=#{updateTime} where id=#{id}")
    void updatePromotionSpace(PromotionSpace promotionSpace);
}

