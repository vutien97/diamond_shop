package diamondShop.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDtoMapper implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
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
		productDto.setCreated_at(rs.getDate("created_at"));
		productDto.setUpdated_at(rs.getDate("updated_at"));
		
		return productDto;
	}

}
