package top.soft1010.java.knowledge.point.reflect;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangjifu on 19/10/10.
 */
public class ReflectUtils {

    /**
     * getFields 获取所有public的成员变量 包含本类和从子类继承来的
     *
     * @param cls
     */
    public static void parseFileds(Class cls) {
        //获取所有public的成员变量 包含本类和从子类继承来的
        Field[] fields1 = cls.getFields();
        for (Field field : fields1) {
            System.out.print(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getName() + field.getName());
            System.out.println("");
        }
    }

    /**
     * getDeclaredFields 获取本类所有变量，所有权限
     *
     * @param cls
     */
    public static void parseDeclaredFileds(Class cls) {
        //获取本类所有变量，所有权限
        Field[] fields2 = cls.getDeclaredFields();

        for (Field field : fields2) {
            System.out.print(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getName() + field.getName());
            System.out.println("");
        }
    }

    /**
     * 获取类的方法
     *
     * @param cls
     */
    public static void parseMethods(Class cls) {
        //获取自己及父类public的方法
//        Method[] methods = subCls.getMethods();
        //获取本类所有权限的方法
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            //获取方法的入参信息
            Parameter[] parameters = method.getParameters();
            System.out.print(Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getName() + " " + method.getName());
            System.out.print("(");
            //入参
            if (parameters != null && parameters.length > 0) {
                StringBuffer argsStr = new StringBuffer();
                for (Parameter parameter : parameters) {
                    argsStr.append(parameter.getType().getName()).append(" ").append(parameter.getName()).append(",");
                }
                System.out.print(argsStr.substring(0, argsStr.length() - 1));
            }
            System.out.print(")");
            //异常信息
            Class[] exceptionClss = method.getExceptionTypes();
            if (exceptionClss != null && exceptionClss.length > 0) {
                System.out.print("throws ");
                StringBuffer exceptionSb = new StringBuffer();
                for (Class exceptionCls : exceptionClss) {
                    exceptionSb.append(exceptionCls.getName()).append(",");
                }
                System.out.print(exceptionSb.substring(0, exceptionSb.length() - 1));
            }
            System.out.println();
        }
    }

    /**
     * getClasses 得到该类及其父类所有的public的内部类
     *
     * @param cls
     */
    public static void parseInnerClass(Class cls) {
        //getClasses 得到该类及其父类所有的public的内部类。
        Class[] classes = cls.getClasses();
        for (Class clz : classes) {
            System.out.println(clz.getName());
        }
    }

    /**
     * getDeclaredClasses 得到该类所有的内部类，除去父类的
     *
     * @param cls
     */
    public static void parseInnerDeclaredClass(Class cls) {
        //getDeclaredClasses 得到该类所有的内部类，除去父类的
        Class[] classes = cls.getDeclaredClasses();
        for (Class clz : classes) {
            System.out.println(clz.getName());
        }
    }

    /**
     * 修改私有变量
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void modifyFiled() throws NoSuchFieldException, IllegalAccessException {
        SubClass subClass = new SubClass();
        subClass.setSubName("subname");
        Class cls = subClass.getClass();
        Field field = cls.getDeclaredField("subName");
        System.out.println();
        //设置访问权限
        field.setAccessible(true);
        System.out.println("修改前 subname:" + subClass.getSubName());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field.set(subClass, "subNameNew");
        System.out.println("修改后 subname:" + subClass.getSubName());
    }

    /**
     * 修改私有常量
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void modifyFinalFiled() throws NoSuchFieldException, IllegalAccessException {
        SubClass subClass = new SubClass();
        Class cls = subClass.getClass();
        Field field = cls.getDeclaredField("finalInt");
        System.out.println("私有变量finalInt 通过反射修改 值 1--> 2");
        //设置访问权限
        field.setAccessible(true);
        //直接获取对象指定私有常量的值
        System.out.println("反射前 finalInt:" + field.get(subClass));
        //通过get方法获取私有常量的值
        System.out.println("反射前 getfinalInt():" + subClass.getFinalInt());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field.set(subClass, 2);
        //直接获取修改后对象指定私有常量的值
        System.out.println("反射后 finalInt:" + field.get(subClass));
        //通过get方法获取修改后私有常量的值
        System.out.println("反射后 getfinalInt():" + subClass.getFinalInt());

        System.out.println("===华丽的分割线===");
        System.out.println("私有变量finalInteger 通过反射修改 11-->12");
        Field field1 = cls.getDeclaredField("finalInteger");
        //设置访问权限
        field1.setAccessible(true);
        //直接获取对象指定私有常量的值
        System.out.println("反射前 finalInteger:" + field1.get(subClass));
        //通过get方法获取私有常量的值
        System.out.println("反射前 getfinalInteger():" + subClass.getFinalInteger());
        //field是私有变量 subClass是要修改的对象 subNameNew是修改成的目标值
        field1.set(subClass, 12);
        //直接获取修改后对象指定私有常量的值
        System.out.println("反射后 finalInteger:" + field1.get(subClass));
        //通过get方法获取修改后私有常量的值
        System.out.println("反射后 getfinalInteger():" + subClass.getFinalInteger());
    }

    /**
     * 动态调用类的私有方法
     *
     * @param cls
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void invokePrivateMethod(Class cls) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取指定方法
        Method privateMethod = cls.getDeclaredMethod("privateMethod", String.class, Integer.class);
        //对于private方法，需要设置访问权限
        privateMethod.setAccessible(true);

        privateMethod.invoke(cls.newInstance(), "zhang", 321);
        System.out.println("调用公有方法");
        //获取指定方法
        Method publicMethod = cls.getDeclaredMethod("publicMethod", String.class, Integer.class);
        //对于public方法，不需要设置访问权限
//        publicMethod.setAccessible(true);

        publicMethod.invoke(cls.newInstance(), "zhang", 123456);

    }

    /**
     * 加载指定.class文件
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public static List<Class> loacExtendClass(String filePath) throws Exception {
        List<Class> classes = new ArrayList<>(16);
        filePath = "/Users/zhangjifu/myproject/java-base/src/main/java/";
        // 设置class文件所在根路径
        // 例如/usr/java/classes下有一个test.App类，则/usr/java/classes即这个类的根路径，而.class文件的实际位置是/usr/java/classes/test/App.class
        File clazzPath = new File(filePath);

        // 记录加载.class文件的数量
        int clazzCount = 0;

        if (clazzPath.exists() && clazzPath.isDirectory()) {
            // 获取路径长度
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;

            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);

            // 遍历类路径
            while (stack.isEmpty() == false) {
                File path = stack.pop();
                File[] classFiles = path.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        return pathname.isDirectory() || pathname.getName().endsWith(".class");
                    }
                });
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            boolean accessible = method.isAccessible();
                            try {
                                if (accessible == false) {
                                    method.setAccessible(true);
                                }
                                // 设置类加载器
                                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                                // 将当前类路径加入到类加载器中
                                method.invoke(classLoader, clazzPath.toURI().toURL());
                            } finally {
                                method.setAccessible(accessible);
                            }
                        }
                        // 文件名称
                        String className = subFile.getAbsolutePath();
                        className = className.substring(clazzPathLen, className.length() - 6);
                        className = className.replace(File.separatorChar, '.');
                        // 加载Class类
                        Class cls = Class.forName(className);
                        System.out.println("读取应用程序类文件 " + className);
                        classes.add(cls);
                    }
                }
            }
        }
        return classes;
    }

}
