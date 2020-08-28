package com.itaem.crazy.shirodemo.modules.shiro.service.impl;

import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryUserCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.UpdatePwdCommand;
import com.itaem.crazy.shirodemo.modules.shiro.dao.UserRepository;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import com.itaem.crazy.shirodemo.modules.shiro.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis2.AxisFault;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service.impl
 * @Description:
 * @MClassName: UserServiceImpl
 * @Authur: yangjianyi
 * @Date: 2020/4/17 16:15
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public SuccessResponse queryUserList(QueryUserCommand command) {
        SuccessResponse successResponse = new SuccessResponse();
        Specification<User> specification = new Specification<User>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if (!StringUtils.isEmpty(command.getUsername())) { //添加断言
                    Predicate stockName = cb
                            .like(root.get("username").as(String.class), "%" + command.getUsername() + "%");
                    predicates.add(stockName);
                }
                if (!StringUtils.isEmpty(command.getSno())) {
                    Predicate sno = cb.like(root.get("sno").as(String.class), "%" + command.getSno() + "%");
                    predicates.add(sno);
                }
                if (!StringUtils.isEmpty(command.getPhone())) {
                    Predicate phone = cb.like(root.get("phone").as(String.class), "%" + command.getPhone() + "%");
                    predicates.add(phone);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        log.info("========pageNumber:" + command.getPage_number() + "======pageSize:" + command.getPage_size());
        //分页信息
        Pageable pageable = new PageRequest(Integer.valueOf(command.getPage_number()) - 1,
                Integer.valueOf(command.getPage_size())); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        Page<User> page = userRepository.findAll(specification, pageable);
        successResponse.setData(page);
        return successResponse;
    }

    @Override
    @Transactional
    public SuccessResponse updatePwd(UpdatePwdCommand command) {
        SuccessResponse response = new SuccessResponse();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (!user.getPassword().equals(command.getPassword())) {
            response.setResultCode(ReturnCode.CLIENT_ERROR.code());
            response.setMessage("原始密码不正确");
        } else if (!command.getNewPwd().equals(command.getNewPassword1())) {
            response.setResultCode(ReturnCode.CLIENT_ERROR.code());
            response.setMessage("两次新密码不一致");
        } else {
            user.setPassword(command.getNewPwd());
            userRepository.save(user);
        }
        return response;
    }

}
