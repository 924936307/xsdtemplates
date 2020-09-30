package com.xsd.template.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        builder.addPropertyValue("name",element.getAttribute("name"));
        builder.addPropertyValue("age",element.getAttribute("age"));
        builder.addPropertyValue("addr",element.getAttribute("addr"));
        builder.addPropertyValue("gender",element.getAttribute("gender"));
    }
}
