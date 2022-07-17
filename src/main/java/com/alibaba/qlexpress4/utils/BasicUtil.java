package com.alibaba.qlexpress4.utils;


import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Character.toUpperCase;

/**
 * @Author TaoKan
 * @Date 2022/5/28 下午5:18
 */
public class BasicUtil {
    public static final String NULL_SIGN = "null";
    public static final String LENGTH = "length";
    public static final String CLASS = "class";
    public static final String NEW = "new";
    public static final String SPLIT_CLASS = "#";
    public static final String SPLIT_NAME = ";";
    public static final String SPLIT_COLLECTOR = ",";

    public static final int LEVEL_FACTOR = 10;
    public static final int DEFAULT_MATCH_INDEX = -1;
    public static final int DEFAULT_WEIGHT = Integer.MAX_VALUE;

    public static boolean classMatchImplicit(Class<?> target, Class<?> source){
        if(target == double.class){
            if(source == float.class || source == long.class || source == int.class || source == short.class || source == byte.class){
                return true;
            }
            return false;
        }else if(target == float.class){
            if(source == long.class || source == int.class || source == short.class || source == byte.class){
                return true;
            }
            return false;
        }else if(target == long.class){
            if(source == int.class || source == short.class || source == byte.class){
                return true;
            }
            return false;
        }else if(target == int.class){
            if(source == short.class || source == byte.class){
                return true;
            }
            return false;
        }else if(target == short.class && source == byte.class){
            return true;
        }
        return false;
    }


    public static boolean classMatchImplicitExtend(Class<?> target, Class<?> source){
        if(target == BigDecimal.class || target == BigInteger.class){
            if(source == double.class || source == float.class || source == long.class || source == int.class || source == short.class || source == byte.class){
                return true;
            }else if(source == Double.class || source == Float.class || source == Long.class || source == Integer.class || source == Short.class || source == Byte.class){
                return true;
            }
            return false;
        }else if(target == double.class || target == float.class || target == long.class || target == int.class || target == short.class || target == byte.class){
            if(source == BigDecimal.class || source == BigInteger.class){
                return true;
            }
            return false;
        }else if(source == Double.class || source == Float.class || source == Long.class || source == Integer.class || source == Short.class || source == Byte.class){
            if(source == BigDecimal.class || source == BigInteger.class){
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isPublic(Member member) {
        return Modifier.isPublic(member.getModifiers());
    }

    public static boolean isStatic(Member member) {
        return Modifier.isStatic(member.getModifiers());
    }

    public static String getGetter(String s) {
        return new StringBuilder().append("get").append(toUpperCase(s.charAt(0))).append(s, 1, s.length()).toString();
    }

    public static String getSetter(String s) {
        return new StringBuilder().append("set").append(toUpperCase(s.charAt(0))).append(s, 1, s.length()).toString();
    }

    public static String getIsGetter(String s) {
        return new StringBuilder().append("is").append(toUpperCase(s.charAt(0))).append(s, 1, s.length()).toString();
    }

    public static Class<?>[] getTypeOfObject(Object[] objects) {
        if (objects == null) {
            return null;
        }
        Class<?>[] classes = new Class<?>[objects.length];
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                classes[i] = null;
            } else {
                classes[i] = objects[i].getClass();
            }
        }
        return classes;
    }



    public static int hashAlgorithmWithNoForNumber(int h){
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }


    public static Class<?> transToPrimitive(Class<?> clazz){
        if(clazz == Boolean.class){
            clazz = boolean.class;
        } else if (clazz == Byte.class) {
            clazz = byte.class;
        } else if (clazz == Short.class) {
            clazz = short.class;
        } else if (clazz == Integer.class) {
            clazz = int.class;
        } else if (clazz == Long.class) {
            clazz = long.class;
        } else if (clazz == Float.class) {
            clazz = float.class;
        } else if (clazz == Double.class) {
            clazz = double.class;
        } else if (clazz == Character.class) {
            clazz = char.class;
        }
        return clazz;
    }
}
