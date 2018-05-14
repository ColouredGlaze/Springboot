package com.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author MingTie
 * CreateDate：2017/8/20
 * Description：添加Xml配置
 * ImportResouce有两种常用的引入方式：classpath和file，具体查看如下的例子：
 * classpath路径：locations={"application-bean1.xml","application-bean2.xml"}
 * file路径：locations = {"file:d:/test/application-bean1.xml"};
 */
@Configuration
@ImportResource(locations = "application-bean.xml")
public class AddXmlConfiguration {
}
