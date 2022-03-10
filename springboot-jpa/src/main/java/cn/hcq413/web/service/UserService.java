package cn.hcq413.web.service;

import cn.hcq413.web.pojo.User;
import org.springframework.data.domain.Page;

public interface UserService  {

      Page<User> findPage(Integer pageNum, Integer pageSize);
}
