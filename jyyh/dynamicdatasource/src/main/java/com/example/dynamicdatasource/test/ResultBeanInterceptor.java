package com.example.dynamicdatasource.test;//package com.miaoshaproject.test;
//
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 后台传参拦截器，将参数转换成ResultBean对象
// *
// * @author lins
// */
//
//public class ResultBeanInterceptor implements HandlerInterceptor {
//
//    /**
//     * 拦截进入控制器方法之前,将resultBean对象放入request作用域
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//        ResultBean resultBean = new ResultBean();
//        request.setAttribute(ResultBean.WEB_RESULT_BEAN, resultBean);
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // Do nothing
//    }
//}
