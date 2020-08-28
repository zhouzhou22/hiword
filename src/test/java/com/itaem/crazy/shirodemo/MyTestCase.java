package com.itaem.crazy.shirodemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo
 * @Description:
 * @MClassName: MyTestCase
 * @Authur: yangjianyi
 * @Date: 2020/5/7 18:20
 */
public class MyTestCase extends TestCase {

    public void testDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
    }
}
