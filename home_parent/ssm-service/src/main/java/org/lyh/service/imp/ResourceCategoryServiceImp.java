package org.lyh.service.imp;

import org.lyh.bean.ResourceCategory;
import org.lyh.mapper.ResourceCategoryMapper;
import org.lyh.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCategoryServiceImp implements ResourceCategoryService {

    @Autowired
    ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }
}
