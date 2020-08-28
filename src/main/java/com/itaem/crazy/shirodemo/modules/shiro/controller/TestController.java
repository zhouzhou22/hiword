package com.itaem.crazy.shirodemo.modules.shiro.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Charts;
import com.itaem.crazy.shirodemo.modules.shiro.entity.Role;
import com.itaem.crazy.shirodemo.modules.shiro.entity.TestEntry;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 大誌
 * @Date 2019/4/7 15:20
 * @Version 1.0
 */
@RestController("/test")
public class TestController {

    @RequiresPermissions({"save"}) //没有的话 AuthorizationException
    @PostMapping("/save")
    public Map<String, Object> save(String token) {
        System.out.println("save");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有save的权力");
        return map;
    }

    @RequiresPermissions({"delete"}) //没有的话 AuthorizationException
    @DeleteMapping("/delete")
    public Map<String, Object> delete(String token) {
        System.out.println("delete");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有delete的权力");
        return map;
    }

    @RequiresPermissions({"update"}) //没有的话 AuthorizationException
    @PutMapping("update")
    public Map<String, Object> update(String token) {
        System.out.println("update");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有update的权力");
        return map;
    }

    @RequiresPermissions({"select"}) //没有的话 AuthorizationException
    @GetMapping("select")
    public Map<String, Object> select(String token, HttpSession session) {
        System.out.println("select");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有select的权力");
        return map;
    }

    @RequiresRoles({"vip"}) //没有的话 AuthorizationException
    @GetMapping("/vip")
    public Map<String, Object> vip(String token) {
        System.out.println("vip");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有VIP角色");
        return map;
    }

    @RequiresRoles({"svip"}) //没有的话 AuthorizationException
    @GetMapping("/svip")
    public Map<String, Object> svip(String token) {
        System.out.println("svip");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有SVIP角色");
        return map;
    }

    @RequiresRoles({"p"}) //没有的话 AuthorizationException
    @GetMapping("/p")
    public Map<String, Object> p(String token) {
        System.out.println("p");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有P角色");
        return map;
    }

    public static void main(String[] args) {
       /* SuccessResponse response = new SuccessResponse();
        TestEntry testEntry = new TestEntry();
        User user= new User();
        user.setPassword("1");
        Role role = new Role();
        role.setRoleId(2);
        testEntry.setRole(role);
        testEntry.setUser(user);
        response.setData(testEntry);
        Map<String, SuccessResponse> map=new LinkedHashMap<>();
        map.put("pro", response);

        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(JSON.toJSON(map)));*/
        /*List<Charts> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = 1;
            Charts charts = new Charts();
            charts.setId(i);
            charts.setStockName(String.valueOf(a++));
            Charts charts1 = new Charts();
            charts1.setId(i);
            charts1.setStockName(String.valueOf(a++));
            list.add(charts);
            list.add(charts1);
        }
        Map<Long, List<Charts>> map = list.stream().collect(Collectors.groupingBy(g -> g.getId()));

        for(Map.Entry<Long, List<Charts>> entry : map.entrySet()){
            Long mapKey = entry.getKey();
            List<Charts> mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }
        System.out.println("============================================================================================");
        for(Long key : map.keySet()) {
            List<Charts> charts = map.get(key);
            charts.stream().forEach(o -> {
                o.setPrice(o.getId());
            });
            Charts c = new Charts();
            c.setId(123);
            c.setStockName("yangjy");
            charts.add(c);
            charts.addAll(new ArrayList<Charts>());
        }
        for(Map.Entry<Long, List<Charts>> entry : map.entrySet()){
            Long mapKey = entry.getKey();
            List<Charts> mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }*/
       /* List<String> strs = new ArrayList<>();
        strs.add("2");
        List<String> collect = strs.stream().filter(f -> f.equals("3")).collect(Collectors.toList());
        System.out.println(collect.size());

        Double a = 1.3;
        Double b = 1.5;
        System.out.println(a - b );*/

       List<String> list = new ArrayList<>();
        List<String> collect = list.stream().filter(f -> f.equals("12")).collect(Collectors.toList());
        System.out.println(collect.size());

    }


}
