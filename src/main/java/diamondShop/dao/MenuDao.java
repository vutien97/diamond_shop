package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.Menu;
import diamondShop.entites.mapper.MenuMapper;
@Repository
public class MenuDao extends BaseDao{
	public List<Menu> getDataMenu(){
		List<Menu> listMenu = new ArrayList<Menu>();
		String sql = "SELECT * FROM menu";
		listMenu = _jdbcTemplate.query(sql, new MenuMapper());
		return listMenu;
	}
}
