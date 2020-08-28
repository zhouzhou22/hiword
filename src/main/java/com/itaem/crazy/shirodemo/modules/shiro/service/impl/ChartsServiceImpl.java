package com.itaem.crazy.shirodemo.modules.shiro.service.impl;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryChartsCommand;
import com.itaem.crazy.shirodemo.modules.shiro.dao.ChartsRepository;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Charts;
import com.itaem.crazy.shirodemo.modules.shiro.service.ChartsService;
import java.util.ArrayList;
import java.util.List;
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
 * @ProjectName ：com.yangjy.demo.db1.service
 * @Description:
 * @MClassName: ChartsService
 * @Authur: yangjianyi
 * @Date: 2020/4/1 17:06
 */
@Service
@Slf4j
public class ChartsServiceImpl implements ChartsService{

    @Autowired
    private ChartsRepository chartsRepository;

    /**
     * 根据名字查找用户
     */
    @Override
    public SuccessResponse queryChartsList(QueryChartsCommand command) {
        SuccessResponse successResponse = new SuccessResponse();
        Specification<Charts> specification = new Specification<Charts>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Charts> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(!StringUtils.isEmpty(command.getStockName())){ //添加断言
                    Predicate stockName = cb.like(root.get("stockName").as(String.class),"%"+command.getStockName()+"%");
                    predicates.add(stockName);
                }
                if(!StringUtils.isEmpty(command.getStartDateStr())) {
                    Predicate startDate = cb.greaterThanOrEqualTo(root.get("date").as(String.class), command.getStartDateStr());
                    predicates.add(startDate);
                }
                if(!StringUtils.isEmpty(command.getEndDateStr())) {
                    Predicate endDate = cb.lessThanOrEqualTo(root.get("date").as(String.class), command.getEndDateStr());
                    predicates.add(endDate);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        log.info("========pageNumber:"+command.getPage_number()+"======pageSize:"+command.getPage_size());
        //分页信息
        Pageable pageable = new PageRequest(Integer.valueOf(command.getPage_number())-1, Integer.valueOf(command.getPage_size())); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        Page<Charts> page =  chartsRepository.findAll(specification,pageable);
        successResponse.setData(page);
        return successResponse;
    }
/*
    @Override
    public SuccessResponse AddCharts(AddChartsCommand addChartsCommand) {
        SuccessResponse successResponse = new SuccessResponse();
        chartsRepository.insertCharts(addChartsCommand.getStockName(),addChartsCommand.getPrice(),DateUtil.parseDate(addChartsCommand.getDateStr()));
        return successResponse;
    }

    @Override
    public SuccessResponse queryStockNameList() {
        SuccessResponse successResponse = new SuccessResponse();
        List<String> list = chartsRepository.queryStockNameList();
        successResponse.setData(list);
        return successResponse;
    }*/
}
