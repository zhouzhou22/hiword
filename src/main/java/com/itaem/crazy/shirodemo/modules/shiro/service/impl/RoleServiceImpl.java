package com.itaem.crazy.shirodemo.modules.shiro.service.impl;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleDetailCommand;
import com.itaem.crazy.shirodemo.modules.shiro.dao.RoleRepository;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Role;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import com.itaem.crazy.shirodemo.modules.shiro.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service.impl
 * @Description:
 * @MClassName: RoleServiceImpl
 * @Authur: yangjianyi
 * @Date: 2020/6/11 9:34
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 查询角色列表
     */
    @Override
    public SuccessResponse queryRoleList(QueryRoleCommand command) {
        SuccessResponse successResponse = new SuccessResponse();
        Specification<Role> specification = new Specification<Role>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if (!StringUtils.isEmpty(command.getRoleName())) { //添加断言
                    Predicate stockName = cb
                            .like(root.get("roleName").as(String.class), "%" + command.getRoleName() + "%");
                    predicates.add(stockName);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        log.info("========pageNumber:" + command.getPage_number() + "======pageSize:" + command.getPage_size());
        //分页信息
        Pageable pageable = new PageRequest(Integer.valueOf(command.getPage_number()) - 1,
                Integer.valueOf(command.getPage_size())); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        Page<Role> page = roleRepository.findAll(specification, pageable);
        successResponse.setData(page);
        return successResponse;
    }

    /**
     * 查询角色详细
     */
    @Override
    public SuccessResponse queryRoleDetail(QueryRoleDetailCommand command) {
        SuccessResponse successResponse = new SuccessResponse();
        Role role = roleRepository.findByRoleId(command.getRoleId());
        successResponse.setData(role);
        return successResponse;
    }
}
