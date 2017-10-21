package com.company;

public class Main {

    public static void main(String[] args) {

        //SHM<String, String> myHashMap = new SHM<String, String>(50);


        //for (int i = 0; i < 50; i++) {
        //    Double d = Math.random() * 10000000.;
        //    String value = "value for " + d;
        //    myHashMap.put(d + "" , value);
        //}

        SHMD<String, String> newHashMap = new SHMD<>(10);
        newHashMap.put("1","2");
        newHashMap.put("2","3");
        newHashMap.put("3", "4");

        newHashMap.remove("3");
        newHashMap.remove("2");
        newHashMap.remove("1");
        System.out.println(newHashMap.get("1"));
        System.out.println(newHashMap.get("2"));
        System.out.println(newHashMap.get("3"));

    }

    //here 23351860 code 2335185
}
