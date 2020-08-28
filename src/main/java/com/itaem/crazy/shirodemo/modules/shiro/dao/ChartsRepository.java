package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.Charts;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName ：com.yangjy.demo.db1.dao
 * @Description:
 * @MClassName: ChartsDao
 * @Authur: yangjianyi
 * @Date: 2020/4/1 17:12
 */
public interface ChartsRepository extends JpaRepository<Charts, Long> {


    Page<Charts> findAll(Specification<Charts> spec, Pageable pageable);


    /*@Select("insert into charts(stock_name,price,date) values(#{stockName},#{price},#{date})")
    void insertCharts(@Param("stockName") String stockName, @Param("price") double price, @Param("date") Date date);

    @Select("select stock_name AS stockName from charts GROUP BY stock_name")
    List<String> queryStockNameList();*/
}
