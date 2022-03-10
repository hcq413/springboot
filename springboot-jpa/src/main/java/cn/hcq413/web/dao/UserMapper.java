package cn.hcq413.web.dao;

import cn.hcq413.web.pojo.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<TUser> {

}
