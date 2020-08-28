package com.itaem.crazy.shirodemo.modules.shiro.dao;


import com.itaem.crazy.shirodemo.modules.shiro.entity.Charts;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByUserId(Integer userId);

    Page<User> findAll(Specification<User> spec, Pageable pageable);
}
