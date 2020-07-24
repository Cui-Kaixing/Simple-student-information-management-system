package servlet;

import domin.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2020/7/24.
 * 处理学生添加
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String gender=req.getParameter("gender");
        String phone=req.getParameter("phone");
        //String hobby=req.getParameter("hobby");
        String birthday=req.getParameter("birthday");
        String info=req.getParameter("info");
        String [] h = req.getParameterValues("hobby");
        String hobby = Arrays.toString(h);//[篮球，足球]
        hobby = hobby.substring(1,hobby.length()-1);
        //添加到数据库
        //string---data
        System.out.println(name);
        try {

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            Student student = new Student(name,gender,phone,hobby,date,info);
            StudentService service = new StudentServiceImpl();
            service.insert(student);

            //跳转页面
            req.getRequestDispatcher("StudentListServlet").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
