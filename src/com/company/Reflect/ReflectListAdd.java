package com.company.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC on 2017/4/7.
 */
public class ReflectListAdd {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
//        list.add(2);
        try{
            Method m = list.getClass().getMethod("add",Object.class);
            m.invoke(list,123);
        }
        catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        catch(InvocationTargetException e){
            e.printStackTrace();
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
