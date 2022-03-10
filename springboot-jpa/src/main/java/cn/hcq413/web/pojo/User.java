package cn.hcq413.web.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity //表示当前实体类是一个可持久化的对象：该类映射某一张表
@Table(name = "t_user")
public  class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长
    private Integer id;  //唯一标识
    @Column(name = "user_name",length = 20)
    private String userName;
    @Column(name = "password",length = 20)
    private String password;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "sex")
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", sex=" + sex +
                '}';
    }
}