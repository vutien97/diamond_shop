package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.Slide;
import diamondShop.entites.mapper.SlideMapper;

@Repository
public class SlideDao extends BaseDao {
	public List<Slide> getDataSlide() {
		List<Slide> listSlide = new ArrayList<Slide>();
		String sql = "SELECT * FROM slides";
		listSlide = _jdbcTemplate.query(sql, new SlideMapper());
		return listSlide;
	}
}
