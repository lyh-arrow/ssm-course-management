package org.lyh.service;

import com.github.pagehelper.PageInfo;
import org.lyh.bean.Resource;
import org.lyh.bean.ResourceVo;



public interface ResourceService {

    // 资源信息分页&条件查询
    PageInfo<Resource> findAllResource(ResourceVo resourceVo);
}
