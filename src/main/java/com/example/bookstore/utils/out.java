package com.example.bookstore.utils;

import java.util.HashMap;
import java.util.Map;

public class out {
    public static Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];
            // 去掉头部空格
            String key1 = key.trim();
            String value1 = value.trim();
            map.put(key1, value1);
        }
        return map;
    }

    public static void main(String[] args) {
      /*  Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println("source: " + map.toString());

        String mapStr ="key1=value1, key2=value2, key3=value3";
        Map<String, String> newMap = mapStringToMap(mapStr);
        System.out.println("transfer: " + newMap.toString());*/

        String str = "[{\"file\":{},\"status\":\"\",\"message\":\"j\"";
        String[] split = str.split(",");
        //split:{"1","2"}
        System.out.print(str + "\n");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        Map<String, String> map = new HashMap<String, String>();
        for (String string : split) {
            String key = string.split(":")[0];
            String value = string.split(":")[1];
            // 去掉头部空格

            map.put(key, value);
        }
        System.out.print("\n" + map);
       /* Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
       String []out=new String[1000];
        for(int i=0;i<n;i++)
         out[i]=scan.next();
        System.out.print("\n");
        for(int i=0;i<n;i++)
        System.out.print("\""+out[i]+"\":\"\",\n");*/

    }
}
