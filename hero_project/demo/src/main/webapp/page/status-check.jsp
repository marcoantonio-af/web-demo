<%@ page import="java.net.InetAddress" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>status-check</title>
 <%
    String x_forwarded_for = request.getHeader("x-forwarded-for");
    String X_Real_IP = request.getHeader("X-Real-IP");
    String HTTP_X_FORWARDED_FOR = request.getHeader("HTTP_X_FORWARDED_FOR");
    String remoteAddr = request.getRemoteAddr();
     String ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");//支持高防IP
     if (null == ipAddress) {
         ipAddress = request.getHeader("X-Real-IP");//用户真实IP
     }
     if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
         ipAddress = request.getRemoteAddr();
         if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
             //根据网卡取本机配置的IP
             InetAddress inet = null;
             try {
                 inet = InetAddress.getLocalHost();//如果不配置hosts会导致取不到值
                 ipAddress = inet.getHostAddress();
             } catch (Exception ignore) {
             }
         }
     }
     //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
     if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
         if (ipAddress.indexOf(",") > 0) {
             ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
         }
     }
 %>
</head>  
<body>  
 <center>Now time is: <%=new java.util.Date()%></center>  
 <center>you ip is: <%=ipAddress%></center>
 <center>x_forwarded_for: <%=x_forwarded_for%></center>
 <center>HTTP_X_FORWARDED_FOR: <%=HTTP_X_FORWARDED_FOR%></center>
 <center>X_Real_IP: <%=X_Real_IP%></center>
 <center>remoteAddr: <%=remoteAddr%></center>
</body>
</html> 