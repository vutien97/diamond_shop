package diamondShop.entites.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import diamondShop.entites.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product productDto = new Product();
		productDto.setId_product(rs.getLong("id_product"));
		productDto.setId_category(rs.getInt("id_category"));
		productDto.setSize(rs.getString("size"));
		productDto.setName(rs.getString("name"));
		productDto.setPrice(rs.getDouble("price"));
		productDto.setSale(rs.getInt("sale"));
		productDto.setTitle(rs.getString("title"));
		productDto.setHighlight(rs.getBoolean("highlight"));
		productDto.setNew_product(rs.getBoolean("new_product"));
		productDto.setDetail(rs.getString("detail"));
		productDto.setId_color(rs.getLong("id_color"));
		productDto.setName_color(rs.getString("name_color"));
		productDto.setImg(rs.getString("img"));
		productDto.setCode_color(rs.getString("code_color"));
		productDto.setCreated_at(rs.getTimestamp("created_at"));
		productDto.setUpdated_at(rs.getTimestamp("updated_at"));
		productDto.setQuantity(rs.getInt("quantity"));
		
		return productDto;
	}

}
