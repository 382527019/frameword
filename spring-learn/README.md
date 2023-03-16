# spring实现思路

## 1.配置
* 1.1 配置web.xml
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
* 1.2 配置init-param
* 1.3 配置url-pattern
* 1.4 配置Annotation
## 2.初始化
### 2.1 调用init()
### 2.2 IoC容器初始化
### 2.3 扫描相关类 
### 2.4 创建实例并保存进IoC
### 2.5 DI操作
### 2.6 初始化HandlerMapping
## 3.运行
### 3.1 调用doPost()/doGet()
### 3.2 匹配HandlerMapping
### 3.3 反射调用method.invoker()
### 3.4 response.getWrite().writ()
返回结果输出浏览器