package dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.util.TestUtils;
import dao.StudentDao;
import domin.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.Textutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/7/23.
 * StudentDao的实现
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() throws SQLException {
        // 建立连接
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql="select * from stu";
        List<Student> list = queryRunner.query(sql,new BeanListHandler<Student>(Student.class));


        return list;
    }

    @Override
    public void insert(Student student) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        queryRunner.update("insert into stu values(null , ?,?,?,?,?,?)" ,
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );

    }

    @Override
    public void delete(int id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        queryRunner.update("delete from stu where id=?",id);
    }

    @Override
    public Student findStudentById(int id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner.query("select * from stu where id=?", new BeanHandler<Student>(Student.class), id);

    }

    @Override
    public void update(Student student) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        queryRunner.update("update stu set name=?,gender=?,phone=?,birthday=?,hobby=?,info=? where id=?",
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getId());

    }

    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql="select * from stu where 1=1 ";
        List<String> list = new ArrayList<String>();

        if(!Textutils.isEmpty(name)){
            sql=sql+"and name like ?";
            list.add("%"+name+"%");
        }
        if(!Textutils.isEmpty(gender)){
            sql+="and gender = ?";
            list.add(gender);
        }

        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),list.toArray());
    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql="select * from stu limit ? offset ?";
        //5 0 --1页 （1-1）*5
        //5 5 --2页 （2-1）*5
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);


    }

    @Override
    public int findCount() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        //用于处理平均值总的个数
        long result = (Long) queryRunner.query("select count(*) from stu",new ScalarHandler());
        return (int) result;
    }
}
