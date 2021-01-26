package org.lyh.mapper;

import org.apache.ibatis.annotations.Update;
import org.lyh.bean.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    //分页查询广告信息
    List<PromotionAd> findAllPromotionAdByPage();

    //更新广告状态
    @Update("update promotion_ad set status = #{status},updateTime = #{updateTime} where id = #{id}")
    void updatePromotionAdStatus(PromotionAd promotionAd);
}
