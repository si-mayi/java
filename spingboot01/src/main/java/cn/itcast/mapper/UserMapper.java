package cn.itcast.mapper;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();
}
