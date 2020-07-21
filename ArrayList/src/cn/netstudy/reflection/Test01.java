package cn.netstudy.reflection;


/**
 * 学习反射
 * TODO 双亲委派机制
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器 ----> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取系统类加载器的父类加载器 ----> 根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("cn.netstudy.reflection.Test01").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;
         * C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;
         * E:\Workspace\IdeaProjects\java-basic\out\production\ArrayList;
         * E:\DevTools\Toolbox\apps\IDEA-U\ch-0\192.7142.36\lib\idea_rt.jar
         */

    }

}
