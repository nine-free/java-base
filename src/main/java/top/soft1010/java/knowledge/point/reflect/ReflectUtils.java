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

    public static void parseConstructors(Class cls, boolean declared) {
        Constructor[] constructors;
        if (declared) {
            constructors = cls.getDeclaredConstructors();
        } else {
            constructors = cls.getConstructors();
        }
        for (Constructor constructor : constructors) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Modifier.toString(constructor.getModifiers())).append(" ")
                    .append(constructor.getName()).append("(");
            //参数
            Parameter[] parameters = constructor.getParameters();
            if (parameters != null && parameters.length > 0) {
                for (Parameter parameter : parameters) {
                    stringBuffer.append(parameter.getType().getName()).append(" ").append(parameter.getName()).append(",");
                }
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
            stringBuffer.append(")");
            //异常信息
            Class[] exceptionClss = constructor.getExceptionTypes();
            if (exceptionClss != null && exceptionClss.length > 0) {
                stringBuffer.append(" throws ");
                StringBuffer exceptionSb = new StringBuffer();
                for (Class exceptionCls : exceptionClss) {
                    exceptionSb.append(exceptionCls.getName()).append(",");
                }
                stringBuffer.append(exceptionSb.substring(0, exceptionSb.length() - 1));
            }
            System.out.println(stringBuffer.toString());
        }
    }

    /**
     * getFields 获取所有public的成员变量 包含本类和从子类继承来的
     * getDeclaredFields 获取本类所有变量，所有权限
     *
     * @param cls
     */
    public static void parseFileds(Class cls, boolean declared) {
        Field[] fields;
        if (declared) {
            //获取本类所有变量，所有权限
            fields = cls.getDeclaredFields();
        } else {
            //获取所有public的成员变量 包含本类和从子类继承来的
            fields = cls.getFields();
        }
        for (Field field : fields) {
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
    public static void parseMethods(Class cls, boolean declared) {
        Method[] methods = null;
        if (!declared) {
            //获取自己及父类public的方法
            methods = cls.getMethods();
        } else {
            //获取本类所有权限的方法
            methods = cls.getDeclaredMethods();
        }
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
     * getDeclaredClasses 得到该类所有的内部类，除去父类的
     *
     * @param cls
     */
    public static void parseInnerClass(Class cls, boolean declared) {
        Class[] classes;
        if (declared) {
            //getDeclaredClasses 得到该类所有的内部类，除去父类的
            classes = cls.getDeclaredClasses();
        } else {
            //getClasses 得到该类及其父类所有的public的内部类。
            classes = cls.getClasses();
        }
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

        System.out.println("=============");
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
        System.out.println("调用私有方法");
        //方法名 + 所有的参数类型（无参则不写）可变参数使用数组 如：可变参数为String的可变参数，则这里String[].class
        Method privateMethod = cls.getDeclaredMethod("privateMethod", String.class);
        //对于private方法，需要设置访问权限 对于public方法，不需要设置访问权限
        privateMethod.setAccessible(true);
        privateMethod.invoke(cls.newInstance(), "zhang");
    }

    /**
     * @param obj
     * @param methodName
     * @param args
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void invokeMethod(Object obj, String methodName, String... args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("调用可变参数公有方法");
        //获取指定方法 可变参数使用数组 如：可变参数为String的可变参数，则这里String[].class
        Method publicMethod = obj.getClass().getDeclaredMethod(methodName, String[].class);
        //对于public方法，不需要设置访问权限
        // publicMethod.setAccessible(true);
        //注意
        //error java.lang.IllegalArgumentException: wrong number of arguments
        //publicMethod.invoke(obj, new Object[]{"111", "222"});
        //done 这里的参数对于可变参数一定是new Object[]{可变参数} 可变参数作为一个整体
        //数组是可协变的，new String[]{"111", "222"}协变为Object
        //publicMethod.invoke(obj, new Object[]{new String[]{"111", "222"}});
        publicMethod.invoke(obj, new Object[]{args});
    }

    //数组可协变
    private void test() {
        Object o = new int[]{};
        Object o1 = new Integer[]{};
        Object[] o2 = new Integer[]{};

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
