package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domin.PageBean;
import domin.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/7/23.
 * 学生业务实现
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao dao= new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int id) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(id);
    }

    @Override
    public Student findStudentById(int id) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentById(id);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);
    }

    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.searchStudent(name,gender);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        PageBean<Student> pageBean=new PageBean<Student>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(StudentDao.PAGE_SIZE);
        StudentDao dao = new StudentDaoImpl();
        int count=dao.findCount();//总的记录数

        List<Student> list =new StudentDaoImpl().findStudentByPage(currentPage);
        pageBean.setList(list);

        //总的记录数，总的页数
        pageBean.setTotalSize(count);
        pageBean.setTotalPage(count%StudentDao.PAGE_SIZE==0 ? count/StudentDao.PAGE_SIZE : (count/StudentDao.PAGE_SIZE)+1);
        return pageBean;
    }
}
