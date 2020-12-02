package diamondShop.entites.entityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import diamondShop.entites.Slide;

public class SlideMapper implements RowMapper<Slide> {

	@Override
	public Slide mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slide slide = new Slide();
		slide.setId(rs.getInt("id"));
		slide.setImg(rs.getString("img"));
		slide.setCaption(rs.getString("caption"));
		slide.setContent(rs.getString("content"));
		// TODO Auto-generated method stub
		return slide;
	}

}
