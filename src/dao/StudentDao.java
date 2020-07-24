package dao;

import domin.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/7/23.
 * 针对学生表的数据访问
 */
public interface StudentDao {
    //一页显示多少数据
    int PAGE_SIZE=5;
    //查找学生所有信息
    List<Student> findAll() throws SQLException;

    //添加学生信息
    void insert(Student student) throws SQLException;

    //删除学生信息
    void delete(int id) throws SQLException;

    //根据id查找学生信息
    Student findStudentById(int id) throws SQLException;

    //更新学生信息
    void update(Student student) throws SQLException;

    //模糊查询
    List<Student> searchStudent(String name,String gender) throws SQLException;

    //查询当页的信息
    List<Student> findStudentByPage(int currentPage) throws SQLException;

    //查询总的学生记录数
    int findCount() throws SQLException;
}
