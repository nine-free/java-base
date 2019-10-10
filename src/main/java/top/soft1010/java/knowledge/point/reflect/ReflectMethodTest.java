package top.soft1010.java.knowledge.point.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by zhangjifu on 19/10/8.
 */
public class ReflectMethodTest {

    public static void main(String[] args) {

        Class subCls = SubClass.class;
        System.out.println("类名：" + subCls.getName());
        //获取自己及父类public的方法
//        Method[] methods = subCls.getMethods();
        //获取本类所有权限的方法
        Method[] methods = subCls.getDeclaredMethods();
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
}
