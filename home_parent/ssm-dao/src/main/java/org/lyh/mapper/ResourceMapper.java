package org.lyh.mapper;

import org.lyh.bean.Resource;
import org.lyh.bean.ResourceVo;

import java.util.List;

public interface ResourceMapper {

    // 资源信息分页&条件查询
    List<Resource> findAllResource(ResourceVo resourceVo);

}
