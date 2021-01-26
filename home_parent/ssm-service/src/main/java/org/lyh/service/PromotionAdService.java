package org.lyh.service;

import com.github.pagehelper.PageInfo;
import org.lyh.bean.PromotionAd;
import org.lyh.bean.PromotionAdVO;



public interface PromotionAdService {

    //分页查询广告信息
    PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    //更新广告状态
    void updatePromotionAdStatus(Integer id,Integer status);
}
