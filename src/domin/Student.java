package domin;

import java.util.Date;

/**
 * Created by Administrator on 2020/7/23.
 * 学生对象
 */
public class Student {
    private int id;
    private String name;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;

    public Student() {
        super();
    }

    public Student(String name, String gender, String phone, String hobby, Date birthday, String info) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }
    public Student(int id,String name, String gender, String phone, String hobby, Date birthday, String info) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getHobby() {
        return hobby;
    }

    public String getInfo() {
        return info;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
