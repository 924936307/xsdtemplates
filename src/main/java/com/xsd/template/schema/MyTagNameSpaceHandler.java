package com.xsd.template.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyTagNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        //"user"对应xds文件里<xsd:element name="user">
        //这里是告诉spring 使用UserBeanDefinitionParser解析器解析name="user"这个元素
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
