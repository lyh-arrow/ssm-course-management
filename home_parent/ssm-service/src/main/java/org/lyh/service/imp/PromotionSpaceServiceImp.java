package org.lyh.service.imp;


import org.lyh.bean.PromotionSpace;
import org.lyh.mapper.PromotionSpaceMapper;
import org.lyh.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImp implements PromotionSpaceService {

    @Autowired
    PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        promotionSpace.setCreateTime(LocalDateTime.now());
        promotionSpace.setUpdateTime(LocalDateTime.now());
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        promotionSpace.setUpdateTime(LocalDateTime.now());
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
