package diamondShop.entites.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import diamondShop.entites.BillDetail;

public class BillDetailMapper implements RowMapper<BillDetail> {

	@Override
	public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetail billDetail = new BillDetail();
		billDetail.setId(rs.getLong("id"));
		billDetail.setId_product(rs.getLong("id_product"));
		billDetail.setId_bill(rs.getLong("id_bill"));
		billDetail.setQuantity(rs.getInt("quantity"));
		billDetail.setTotal(rs.getDouble("total"));
		return billDetail;
	}

}
