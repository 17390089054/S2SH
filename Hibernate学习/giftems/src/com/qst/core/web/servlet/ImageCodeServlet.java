package com.qst.core.web.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 验证码大全
 */
public class ImageCodeServlet extends HttpServlet {
    /**
     * get方法
     */
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置浏览器不要缓存此图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        Map<String,Object> resultMap= ImageCodeUtils.createImageCode();
        // 写到浏览器中、同时保存到Session中
        HttpSession session = request.getSession();
        String rand = String.valueOf(resultMap.get(ValidateCode.RAND));
        session.setAttribute("validateCode", rand);
        byte[] buf = (byte[])resultMap.get(ValidateCode.BUFFER);
        response.setContentLength(buf.length);
        // 获取输出流对象
        ServletOutputStream out = response.getOutputStream();
        out.write(buf);
        // 关闭流
        out.close();
    }
    
    
    private static final long serialVersionUID = 1L;
}
