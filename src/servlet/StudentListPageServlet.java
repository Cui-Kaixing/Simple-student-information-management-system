package servlet;

import domin.PageBean;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2020/7/24.
 */
public class StudentListPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int currentPage=Integer.parseInt(req.getParameter("currentPage"));
            StudentService service = new StudentServiceImpl();
            PageBean pageBean=service.findStudentByPage(currentPage);
            req.setAttribute("pageBean",pageBean);
            req.getRequestDispatcher("list_page.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
