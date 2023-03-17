package top.hygyxx.mvcframework.v2.servlet;

import top.hygyxx.mvcframework.annotation.YGController;
import top.hygyxx.mvcframework.annotation.YGService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

/**
 * 1.继承HttpServlet重写 doGet、doPost、init方法
 */
public class YGDispatchServlet extends HttpServlet {
    /*web.xml init 参数*/
    private final static String initParameter = "contextConfigLocation";
    private Properties properties = new Properties();
    /*properties配置的包扫描路径*/
    private final static String scanPackage = "scanPackage";
    /*IoC 类名缓存 享元模式*/
    private List<String> classNames = new ArrayList<>();
    /*IoC容器 ，Bean默认类名首字母小写，IoC(key=Bean Name，vaule=实例对象)*/
    private Map<String, Object> IoC = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*6.委派url 根据url去找到对应Method并通过response返回*/
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        /*1.加载配置文件*/ //config.getInitParameter(initParameter)拿web.xml配置参数的value
        doLoadConfig(config.getInitParameter(initParameter));
        /*2.扫描相关类*/ //
        doScanner(properties.getProperty(scanPackage));
        /*3.初始化IoC容器，将扫描到的相关类实例化并保存到IoC*/ //IoC
        doInstance();
        /*4.依赖注入完成*/ //DI
        doAutowired();
        /*5.初始化HandlerMapping*/ //===MVC
        doInitHandlerMapping();
        System.out.println("Framework");
    }

    private void doInitHandlerMapping() {
    }

    private void doAutowired() {
    }

    private void doInstance() {
        if (classNames.isEmpty()) return;
        try {
            for (String className : classNames) {
                /*3.1通过类名加载实例对象放入IoC*/
                Class<?> aClass = Class.forName(className);
                /*3.2只有标注特定注解的才控制反转*/
                if (aClass.isAnnotationPresent(YGController.class)) {
                    String beanName = toFirstCase(aClass.getName());
                    Object instance = aClass.newInstance();
                    IoC.put(beanName, instance);
                } else if (aClass.isAnnotationPresent(YGService.class)) {
                    /*3.3.1多个包出现相同类名，只能自己其一个全局唯一的名字*/
                    String beanName = aClass.getAnnotation(YGService.class).value();
                    /*beanName.value是空就取默认*/
                    if ("".equals(beanName.trim())) {
                        beanName = toFirstCase(aClass.getName());
                    }
                    /*3.3.2 默认的类名首字母小写*/
                    Object instance = aClass.newInstance();
                    IoC.put(beanName, instance);
                    /*3.3.3接口 => 一个实现默认注入，多个实现抛异常*/
                    for (Class<?> i : aClass.getInterfaces()) {
                        if (IoC.containsKey(i.getName())) {
                            throw new Exception("The" + i.getName() + "is exists.");
                        }
                        IoC.put(i.getName(), instance);
                    }
                } else continue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toFirstCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doScanner(String scanPackage) {
        /*scanPackage = xx.xx.xxx 要.替换/ => 成/xx/xx/xxx的URL*/
        /*2.1通过包路径拿到 =>URL(/xx/xx资源路径) 加载File文件夹*/
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        if (url == null) return;
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                /*2.2.1递归包路径*/
                doScanner(scanPackage + "." + file.getName());
            } else {
                /*2.2.2 排除.class之外的文件*/
                if (file.getName().endsWith(".class")) continue;
                /*2.2.3 拿到类全名(package.className)加载进缓存 ,类可以用Class.forName(包名.类名)加载*/
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String initParameter) {
        /*1.1拿application.properties文件 =>得文件流*/
        InputStream ips = this.getClass().getClassLoader().getResourceAsStream(initParameter);
        try {
            /*1.2把文件流加载成properties文件*/
            properties.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ips != null) {
                try {
                    ips.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
