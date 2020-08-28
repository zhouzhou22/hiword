package com.itaem.crazy.shirodemo.modules.shiro.service.impl;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Permission;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Role;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import com.itaem.crazy.shirodemo.modules.shiro.service.PermissionService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service.impl
 * @Description:
 * @MClassName: PermissionServiceImpl
 * @Authur: yangjianyi
 * @Date: 2020/4/23 16:40
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Override
    public SuccessResponse queryPermissionList() {
        log.info("[start：查询菜单]");
        SuccessResponse response = new SuccessResponse();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> list = new ArrayList<>();
        if (Objects.nonNull(user)) {
            for (Role role : user.getRoles()) {
                list.addAll(role.getPermissions());
            }
        }
        List<Permission> permissionList = list.stream()
                //Comparator.comparing默认是升序排序，
                .sorted(Comparator.comparingInt(Permission::getPermissionId))
                .collect(Collectors.toList());
        response.setData(permissionList);
        return response;
    }
}
