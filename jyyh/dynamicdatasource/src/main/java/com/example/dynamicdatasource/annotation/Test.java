package com.example.dynamicdatasource.annotation;

public class Test {

    @TestAnnotation("ddse")
    private String s;

    public void getAnnotation(){
        
    }
    
    public static void main(String[] args) {
//             TestAnnotation t =(TestAnnotation) Test.class.getAnnotation(TestAnnotation.class);
//             System.out.println(t.value());
        Test t = new Test();
        t.setS("@s");
        System.out.println("5"+ t.getS());
        }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
