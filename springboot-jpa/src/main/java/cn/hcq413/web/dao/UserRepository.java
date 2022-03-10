package cn.hcq413.web.dao;

import cn.hcq413.web.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    //根据方法名生成sql
    public  List<User> findByUserNameLike(String userName);
}
