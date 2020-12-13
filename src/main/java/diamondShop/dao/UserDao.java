package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.User;
import diamondShop.entites.mapper.UserMapper;

@Repository
public class UserDao extends BaseDao {

	public int addUser(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO user ");
		sql.append("( ");
		sql.append("	role, ");
		sql.append("	email, ");
		sql.append("	password, ");
		sql.append("	display_name, ");
		sql.append("	address, ");
		sql.append("	phone, ");
		sql.append("	created_at, ");
		sql.append("	status ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	" + user.isRole() + ", ");
		sql.append("	'" + user.getEmail() + "', ");
		sql.append("	'" + user.getPassword() + "', ");
		sql.append("	N'" + user.getDisplay_name() + "', ");
		sql.append("	N'" + user.getAddress() + "', ");
		sql.append("	'" + user.getPhone() + "', ");
		sql.append("	'" + user.getCreated_at() + "', ");
		sql.append("	1	 ");
		sql.append(")");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public User getUserByLogin(User user) {
		String sql = "SELECT * FROM user WHERE email = '" + user.getEmail() + "'";

		User result = _jdbcTemplate.queryForObject(sql, new UserMapper());
		return result;
	}

	public List<User> getListUserIn1Month() {
		String sql = "SELECT * FROM user WHERE created_at BETWEEN DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 30 DAY) AND CURRENT_TIMESTAMP";
		List<User> listUser = _jdbcTemplate.query(sql, new UserMapper());
		return listUser;
	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM user WHERE role = 0 AND status = 1";
		List<User> listUser = _jdbcTemplate.query(sql, new UserMapper());
		return listUser;
	}

	public List<User> getListUserPaginate(int start, int totalProductIn1Page) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM user WHERE role = 0 AND status = 1");
		sql.append(" LIMIT " + start + ", " + totalProductIn1Page);
		List<User> listUser = new ArrayList<User>();
		listUser = _jdbcTemplate.query(sql.toString(), new UserMapper());
		return listUser;
	}

	public void deleteUser(User user) {
		String sql = "UPDATE user SET status = 0 WHERE id = " + user.getId();
		_jdbcTemplate.update(sql);
	}
	
	public User getUserById(long id) {
		String sql = "SELECT * FROM user WHERE id = " + id;
		User user = _jdbcTemplate.queryForObject(sql, new UserMapper());
		return user;
	}
}
