package org.lyh.service.imp;

import org.lyh.bean.ResourceCategory;
import org.lyh.mapper.ResourceCategoryMapper;
import org.lyh.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResourceCategoryServiceImp implements ResourceCategoryService {

    @Autowired
    ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        resourceCategory.setCreatedTime(LocalDateTime.now());
        resourceCategory.setUpdatedTime(LocalDateTime.now());
        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
        resourceCategory.setUpdatedTime(LocalDateTime.now());
        resourceCategory.setUpdatedBy("system");
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    @Override
    public void deleteResourceCategory(Integer id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }
}
