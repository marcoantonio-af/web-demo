//package com.example.demo;
//
//import com.example.demo.bisai.ExcelUtil2;
//import com.example.demo.bisai.ExcelWriteUtil;
//import com.example.demo.entity.User;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.util.*;
//
//@Controller
//public class Demo {
//    @Autowired
//    DemoService demoService;
//    /**
//     * 上传文件
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/uploadFile.do", method = {RequestMethod.GET, RequestMethod.POST})
//    public String updateFile(@RequestParam MultipartFile file) throws IOException {
//        FileOutputStream fos = new FileOutputStream("target/" + file.getOriginalFilename());
//        IOUtils.copy(file.getInputStream(), fos);
//        fos.close();
//        return "success";
//    }
//
//    /**
//     * 上传文件
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/uploadFiles.do", method = {RequestMethod.GET, RequestMethod.POST})
//    public String updateFile(@RequestParam MultipartFile[] file) throws Exception {
//        ArrayList<ArrayList<Object>> list = null;
//        StringBuffer sb = new StringBuffer("");
//        long start =System.currentTimeMillis();
//        for (MultipartFile tempFile : file){
//            ArrayList arrayList = ExcelUtil2.readExcel(tempFile.getInputStream(), tempFile.getOriginalFilename(), "GBK");
//            sb.append(tempFile.getOriginalFilename());
//            sb.append(arrayList.size());
//            sb.append("`````````");
//        }
////        long tempListStart = System.currentTimeMillis();
////        for (ArrayList tempList: list){
////            tempList.get(5);
////        }
////        System.out.println("·················结束时间"+ (System.currentTimeMillis()-tempListStart));
////        long tempStart = System.currentTimeMillis();
////
////        list.forEach(temp -> temp.get(5));
////        System.out.println("·················结束时间"+ (System.currentTimeMillis()-tempStart));
//
//
//        long end = System.currentTimeMillis();
//        System.out.println("·················结束时间"+ (end-start)/1000);
//        return "success"+sb;
//    }
//
//
//
//
//    /**
//     * 下载图片
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/getPhoto.do", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.IMAGE_GIF_VALUE)
//    public byte[] getPhoto() throws IOException {
//        String photoFile = "target/a.png";
//        InputStream inputStream = new FileInputStream(photoFile);
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        byte[] buffer = new byte[4096];
//        int n = 0;
//        while (-1 != (n = inputStream.read(buffer))) {
//            output.write(buffer, 0, n);
//        }
//        return output.toByteArray();
//    }
//
//
//    /**
//     * 导出
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/getData.do", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.IMAGE_GIF_VALUE)
//    public void getData(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<String> title = Arrays.asList("姓名", "性别");
//        List<Object> data = new ArrayList<>();
//        Map<String, Object> d = new HashMap<>();
//        d.put("username", "张三");
//        d.put("password", "男");
//        data.add(d);
//        Map<String, Object> f = new HashMap<>();
//        f.put("username", "张四");
//        f.put("password", "男");
//        data.add(f);
//      //  ExcelWriteUtil.writeExcel(title, field, data , "test", "xlsx", response);
//        User user = new User();
//        user.setUsername("zhangjie");
//        user.setPassword("1334");
//        User user1 = new User();
//        user1.setUsername("zhangjie");
//        user1.setPassword("1331111114");
//        List<String> fileds = Arrays.asList("password", "username");
//        List<Object> data1 = new ArrayList<>();
//        data1.add(user);
//        data1.add(user1);
//        ExcelWriteUtil.writeExcel(title, fileds, data1, "test", "xls", response);
//    }
//
//}
//
//
