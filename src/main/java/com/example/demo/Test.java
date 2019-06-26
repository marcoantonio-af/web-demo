package com.example.demo;


import com.example.demo.data.YjServerPrice;
import com.sun.xml.internal.ws.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;


public class Test
{
    private String testName;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    private static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {

//        T map =(c) -> {System.out.println("dd");
//        return c;};
//        map.b("zd");
//        Runnable r2 = () -> System.out.println("hello lambda");
//        r2.run();
//
//        List<String> list = asList("ss");
//        Map<String, Integer> items = new HashMap<>();
//        items.put("A", 10);
//        items.put("B", 20);
//        items.put("C", 30);
//        items.put("D", 40);
//        items.put("E", 50);
//        items.put("F", 60);
//        Set<String> set = items.keySet();
//        items.forEach((k, v) -> {
//            System.out.println("k" + k + "v" + v);
//        });
//
//        items.forEach((k, v) -> {
//
//            System.out.println("k" + k + "v" + v);
//        });
//
//
//
//
//
//        Integer a = 5;
//
//        System.out.println("a"+a);
//        String dd="s";
//
//        List<String> alist = Stream.of("a", "b", "c").collect(Collectors.toList());
//        alist = alist.stream().map(temp -> temp.toUpperCase()).collect(Collectors.toList());
//
//        alist.forEach(temp ->{
//            System.out.println("temp"+temp);
//        });
//        System.out.println(alist.size());
//        List<String> blist = asList("dd", "bb");
//
//        blist.forEach(temp ->{
//            temp = "t" + temp;
//            System.out.println("temp"+temp);
//        });
//
//        List<Integer> ll = asList(1, 5, 7, 2, 99, 50);
//        Integer max = ll.stream().max(Comparator.comparing(temp->temp)).get();
//        System.out.println("max:"+max);
//        Integer min = ll.stream().min(Comparator.comparing(temp->temp)).get();
//        System.out.println("min:"+min);
//
//        int count = Stream.of(1, 2, 3)
//                .reduce(6, (acc1, element) -> acc1 + element);
//        System.out.println(count);
//
//
//        System.out.println(UUID.randomUUID());
//
//        List<String> tagIdsTmp = asList("dd", "ss", "dd", "sed", "ss","dds" );
//        Set<String> tagIdsTmpSet =  new HashSet<>();
//        tagIdsTmpSet = tagIdsTmp.stream().collect(Collectors.toSet());
//        System.out.println(tagIdsTmpSet.size());
//        tagIdsTmp.stream().filter(s->s.startsWith("dd")).collect(Collectors.toSet());
//        tagIdsTmp.forEach(temp->{
//            System.out.println("t"+temp);
//        });
//
//
//        List<String> listString = asList("zdf", "dd", "eez","zd");
//        listString.forEach(e->{System.out.println(""+e);});
//
//
//
//
//
//        Set<String> origins = listString.stream()
//                .filter(artist -> artist.startsWith("zd"))
//
//                .collect(Collectors.toSet());
//        origins.forEach(temp->System.out.println("````````"+temp));
//
//        List<String> listString1 = new LinkedList<>();
//        Set<String> set1 = new HashSet<>();
//        String temp = "";
//        for (int i= 0; i<100000; i++){
//            String s = UUID.randomUUID().toString();
//            listString1.add(s);
//            set1.add(s);
//            if (i == 5000){
//                temp = s;
//            }
//        }

//        String tel ="222";
//        if (tel.matches("^[0-9]{11}$|\\s*")){
//            System.out.println("ok");
//        }else {
//            System.out.println("非空");
//        }

//        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
//        list.forEach(e ->{
//            if(e.length() >= 5){
//                return;
//            }
//            System.out.println(e);
//        });
        String a = "5,n,";
System.out.println(a.substring(0, a.lastIndexOf(",")));




    }

    public void sets(){
        return;
    }


}
