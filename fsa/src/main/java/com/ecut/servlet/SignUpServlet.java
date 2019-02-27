package com.ecut.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet( "/sign/up" )
public class SignUpServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "我执行了" );

        HttpSession session = req.getSession(); // 获取会话对象

        String abc = "hello , 'zhangsanfeng' " ;

        String uname = req.getParameter( "username" ); // <input type="text" name="username" placeholder="请输入用户名">
        System.out.println( "username : " + uname );
        if( uname == null || uname.trim().isEmpty() ) {
            session.setAttribute( "message" , "你丫就不能输入个用户名再试?" );
            resp.sendRedirect( "/0227/sign-up.vm" ); // 重定向 ( redirect ) 到 指定位置 ( /0227/sing-up.vm  )
            return ; // 让当前的service方法立即返回( 停止执行后续代码 )
        }

        //                     <input type="checkbox" name="hobby" value="eat" > 吃
        //                    <input type="checkbox" name="hobby" value="sleep" > 睡
        //                    <input type="checkbox" name="hobby" value="eatji" > 吃鸡
        String[] hobby = req.getParameterValues( "hobby" );
        System.out.println( "hobby : " + Arrays.toString( hobby ) );


        resp.setContentType( "text/html;charset=UTF-8" );
        PrintWriter w = resp.getWriter();
        w.println( "<h1 align='center'>Welcome</h1>" );

        w.println( "<h1 align='center'>" + uname + "</h1>" );

    }

}
