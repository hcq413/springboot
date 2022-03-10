package cn.hcq413.web.junit;

import cn.hcq413.web.dao.FilmInfoRepository;
import cn.hcq413.web.dao.FilmTypeRepository;
import cn.hcq413.web.dao.UserMapper;
import cn.hcq413.web.dao.UserRepository;
import cn.hcq413.web.pojo.FilmInfo;
import cn.hcq413.web.pojo.FilmType;
import cn.hcq413.web.pojo.TUser;
import cn.hcq413.web.pojo.User;
import cn.hcq413.web.service_impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    FilmTypeRepository filmTypeRepository;
    @Autowired
    FilmInfoRepository filmInfoRepository;
    @Test
    public  void  test1(){
        List<User> tUsers = userRepository.findAll();
        tUsers.forEach(System.err::println);
    }
    @Test
    public  void  test2(){
        List<TUser> users = userMapper.selectList(null);
        users.stream().parallel().forEach(System.err::println);
    }
    @Test
    public void test3(){
        List<User> list = userRepository.findByUserNameLike("%j%");
        list.forEach(System.err::println);
    }
    @Test
    public void test4(){
        Page<User> page = userServiceImpl.findPage(0, 5);
        page.forEach(System.err::println);
        System.out.println(page.getNumber());
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
    }

    @Test
    public  void  test5(){
        FilmType type = new FilmType();
        type.setName("喜剧片1");
         filmTypeRepository.save(type);
    }
    @Test
    public  void  test6(){
        FilmInfo filmInfo=new FilmInfo();
        filmInfo.setFilmName("少林足球");
        filmInfo.setActor("周星驰");
        filmInfo.setDirector("周星驰");
        filmInfo.setTicketPrice(300.0);
        FilmType type = filmTypeRepository.findById(1).get();
        filmInfo.setFilmType(type);
        filmInfoRepository.save(filmInfo);
    }
}
