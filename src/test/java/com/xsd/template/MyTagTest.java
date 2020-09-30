package com.xsd.template;

import com.xsd.template.schema.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTagTest {
    private static ClassPathXmlApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/*");
    }

    @Test
    public void test(){
        /*Assert.assertNotNull(ctx);
        //这里的user对象继承了spring-beans.xsd,id属性也是继承过来的，没id属性会报错
        User bobo = ctx.getBean("users", User.class);
        System.out.println(bobo.toString());*/

        User bean = ctx.getBean(User.class);
        Assert.assertNotNull(bean);
        System.out.println(bean.toString());
    }
}
