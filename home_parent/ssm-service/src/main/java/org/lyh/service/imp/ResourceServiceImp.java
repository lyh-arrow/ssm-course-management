package org.lyh.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lyh.bean.Resource;
import org.lyh.bean.ResourceVo;
import org.lyh.mapper.ResourceMapper;
import org.lyh.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResourceServiceImp implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        return new PageInfo<>(allResource);
    }
}
