package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Pattern;

@Controller
public class Login {

    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public void login(User user){
        System.out.println("dd" + user.getUsername());
    }

    @ResponseBody
    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public void test(){
        System.out.println("11111");
        Test test = getTest();
        test.setTestName("@2222");
    }

    @ResponseBody
    @RequestMapping(value = "/test1.do", method = RequestMethod.GET)
    public void test1(){
        System.out.println("11111");
        Test test = getTest();
        System.out.println(test.getTestName());
    }

    @ResponseBody
    @RequestMapping(value = "/updateFile.do", method = RequestMethod.GET)
    public void updateFile(String sfile){
        System.out.println("f"+sfile);

    }

    @Bean
    Test getTest(){
        return new Test();
    }

    public static void main(String[] args) {
       System.out.println(Pattern.compile("\\d").matcher("ree搜索2").find()); ;

       System.out.println(Pattern.matches("\\d", "2"));
        }


}
