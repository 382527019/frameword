# spring

## 1.spring编程思想
|  spring思想    |    应用场景    |总结
| ----          | ----           | ----               
| OOP           | 面向对象       |封装、继承、多态          
|BOP            | 面向Bean       |  一切都是Bean         
|AOP            | 面向切面       |解耦、代理扩展、专人专事 
| IoC           | 控制反转       |对象由Spring统一管理    
| DI/DL         | 依赖注入、查找 |Bean自动赋值、自动保存依赖关系

##2.系统架构

### 2.1 核心模块
|     模块名称      | 主要功能|
|----|----|
|spring-core|依赖注入IoC与DI的最基本实现|
|spring-beans|Bean工厂与Bean装配
|spring-context-support|定义基础Spring的Context上下文即IoC容器
|spring-context-indexer|Spring的类管理组件和Classpath扫描
|spring-expression|Spring表达式语言

### 2.2切面编程模块
|     模块名称      | 主要功能|
|----|----|
|spring-apo|面向切面编程的应用模块，整合JDKProxy、CGLib、Asm
|spring-aspects|集成AspectJ，APO应用框架
|spring-instrument|动态Class Loading模块


### 2.3切面编程模块
|     模块名称      | 主要功能|
|----|----|
|spring-web|提供最基础Web支持，通过Servle或者Listeners来初始化IoC容器|
|spring-webmvc|实现Spinrg MVC 的Web应用
|spring-websocket|Web前端全双工通讯的协议
|spring-webflux|一个新的非阻塞函数式Reactive Web框架，可以用来建立异步的，非阻塞，事件驱动服务

### 2.4测试模块
|     模块名称      | 主要功能|
|----|----|
|spring-test|主要为测试提供支持

### 2.4数据访问域集成模块
|     模块名称      | 主要功能|
|----|----|
|spring-jdbc|Spring提供的JDBC抽象框架的主要实现模块，用于简化Spring JDBC操作
|spring-tx|Spring JDBC 事务控制实现模块
|spring-orm|集成Java Persistence API(JPA) 和Java Data Objects(JDO)
|spring-oxm|将Java对象映射成XML数据，或者将XML数据映射成Java对象
|spring-jms|Java Messaging Service能够发送和接受信息

### 2.5通信报文模块
|     模块名称      | 主要功能|
|----|----|
|spring-messaging|为Spring集成一些基础的报文传送应用
### 2.6集成兼容模块
|     模块名称      | 主要功能|
|----|----|
|spring-frameword-bom|解决Spirng的不同模块依赖版本不同问题