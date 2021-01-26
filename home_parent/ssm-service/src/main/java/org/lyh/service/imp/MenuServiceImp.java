package org.lyh.service.imp;


import org.lyh.bean.Menu;
import org.lyh.mapper.MenuMapper;
import org.lyh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(Integer id) {
        return menuMapper.findSubMenuListByPid(id);
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
