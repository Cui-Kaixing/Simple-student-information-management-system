package service;

import domin.PageBean;
import domin.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/7/23.
 * 学生业务处理规则
 */
public interface StudentService {
    List<Student> findAll() throws SQLException;
    void insert(Student student) throws SQLException;
    void delete(int id) throws SQLException;
    Student findStudentById(int id) throws SQLException;
    void update(Student student) throws SQLException;
    List<Student> searchStudent(String name,String gender) throws SQLException;

    PageBean findStudentByPage(int currentPage) throws SQLException;

}
