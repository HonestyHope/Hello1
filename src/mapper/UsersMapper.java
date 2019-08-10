package mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pojo.Users;

public interface UsersMapper {
	@Results(value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password"),
			@Result(property="menus",many=@Many(select="mapper.MenuMapper.selByPid"),column="{uid=id,pid=pid}")
	})
	@Select("select *,0 pid from users where username=#{username} and password=#{password}")
	Users selByUsers(Users users);
}
