/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.util.test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.noeasy.money.enumeration.OrderType;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 25, 2014
 */

public class ReflectionUtils {

    private static final String     GET_METHOD_PREFIX = "get";

    private static final Set<Class> simpleClassSet    = new HashSet<Class>();

    static {
        simpleClassSet.add(String.class);
        simpleClassSet.add(Double.class);
        simpleClassSet.add(Integer.class);
        simpleClassSet.add(Boolean.class);
        simpleClassSet.add(BigDecimal.class);
        simpleClassSet.add(Date.class);
        simpleClassSet.add(Timestamp.class);
    }



    public static List<String> getFieldsValue(final Object pObject) {

        Class<? extends Object> clazz = pObject.getClass();
        List<String> results = new ArrayList<String>();
        Method[] methods = clazz.getDeclaredMethods();
        results.add("{");
        for (Method method : methods) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                try {
                    String filedName = method.getName().substring(3);
                    Object invokeResult = method.invoke(pObject);
                    String result = "";
                    if (invokeResult == null) {
                        result += filedName + "=" + null;
                        results.add(result);
                    } else if (invokeResult.getClass().equals(List.class)
                            || invokeResult.getClass().equals(ArrayList.class)) {
                        result += filedName + "=[";
                        results.add(result);
                        for (Object obj : (ArrayList<?>) invokeResult) {
                            results.addAll(getFieldsValue(obj));
                        }
                        results.add("]");
                    }

                    else if (simpleClassSet.contains(invokeResult.getClass()) || invokeResult instanceof Enum<?>) {
                        result += filedName + "=" + invokeResult;
                        results.add(result);
                    } else {
                        result += "<br />" + filedName + "=";
                        List<String> subResult = getFieldsValue(invokeResult);
                        subResult.add(0, result);
                        results.addAll(subResult);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        results.add("}");
        return results;
    }



    public static void main(final String[] args) {
        if (OrderType.DORMITORY instanceof Enum<?>) {
            System.out.println(1111);
        }
    }
}
