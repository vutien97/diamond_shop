package diamondShop.entites.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import diamondShop.entites.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setRole(rs.getBoolean("role"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getString("phone"));
		return user;
	}

}
