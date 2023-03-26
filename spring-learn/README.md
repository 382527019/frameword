# spring实现思路

---
## 一、YGDispatchServlet.class
### 1.1.配置
    ~~~
    <display-name>Yungui Web Application</display-name>
        <!--servlet配置-->
        <servlet>
            <servlet-name>ygmvc</servlet-name>
            <servlet-class>top.hygyxx.v2.servlet.YGDispatchServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>application.properties</param-value>
            </init-param>
        </servlet>
        <servlet-mapping>
            <servlet-name>ygmvc</servlet-name>
            <url-pattern>/*</url-pattern>
        </servlet-mapping>
    ~~~
* 1.1.1 配置web.xml
* 1.1.2 配置init-param
* 1.1.3 配置url-pattern
* 1.1.4 配置Annotation
### 1.2.初始化
*  1.2.1 调用init()
*  1.2.2 IoC容器初始化
*  1.2.3 扫描相关类 
*  1.2.4 创建实例并保存进IoC
*  1.2.5 DI操作
*  1.2.6 初始化HandlerMapping
### 1.3.运行
* 1.3.1 调用doPost()/doGet()
* 1.3.2 匹配HandlerMapping
* 1.3.3 反射调用method.invoker()
* 1.3.4 response.getWrite().writ()
返回结果输出浏览器
---
