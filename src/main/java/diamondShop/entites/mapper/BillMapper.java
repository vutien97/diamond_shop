package diamondShop.entites.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import diamondShop.entites.Bill;

public class BillMapper implements RowMapper<Bill> {

	@Override
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();
		bill.setId(rs.getLong("id"));
		bill.setEmail(rs.getString("email"));
		bill.setPhone(rs.getString("phone"));
		bill.setDisplay_name(rs.getString("display_name"));
		bill.setAddress(rs.getString("address"));
		bill.setTotal(rs.getDouble("total"));
		bill.setQuantity(rs.getInt("quantity"));
		bill.setNote(rs.getString("note"));
		bill.setBillDate(rs.getTimestamp("billDate"));
		bill.setStatus(rs.getBoolean("status"));
		return bill;
	}

}
