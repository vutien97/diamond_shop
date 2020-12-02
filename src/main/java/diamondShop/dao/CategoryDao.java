package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.Category;
import diamondShop.entites.entityMapper.CategoryMapper;
@Repository
public class CategoryDao extends BaseDao {
	

	public List<Category> getDataCategory() {
		List<Category> listCategory = new ArrayList<Category>();
		String sql = "SELECT * FROM Categories";
		listCategory = _jdbcTemplate.query(sql, new CategoryMapper());
		return listCategory;
	}
}
