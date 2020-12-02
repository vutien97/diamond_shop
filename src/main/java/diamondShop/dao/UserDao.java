package diamondShop.dao;

import org.springframework.stereotype.Repository;

import diamondShop.entites.User;

@Repository
public class UserDao extends BaseDao {

	public int addUser(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO user ");
		sql.append("( ");
		sql.append("	role, ");
		sql.append("	user, ");
		sql.append("	password, ");
		sql.append("	display_name, ");
		sql.append("	address, ");
		sql.append("	phone ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	" + user.isRole() + ", ");
		sql.append("	'" + user.getUser() + "', ");
		sql.append("	'" + user.getPassword() + "', ");
		sql.append("	N'" + user.getDisplay_name() + "', ");
		sql.append("	N'" + user.getAddress() + "', ");
		sql.append("	'" + user.getPhone() + "' ");
		sql.append(")");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

}
