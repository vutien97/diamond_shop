package diamondShop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.Bill;
import diamondShop.entites.BillDetail;
import diamondShop.entites.mapper.BillMapper;

@Repository
public class BillDao extends BaseDao {

	public int addBill(Bill bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO bill ");
		sql.append("( ");
		sql.append(" `email` ");
		sql.append(", `phone` ");
		sql.append(", `display_name` ");
		sql.append(", `address` ");
		sql.append(", `total` ");
		sql.append(", `quantity` ");
		sql.append(", `note` ");
		sql.append(", `billDate` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("  '" + bill.getEmail() + "' ");
		sql.append(", '" + bill.getPhone() + "' ");
		sql.append(", '" + bill.getDisplay_name() + "' ");
		sql.append(", '" + bill.getAddress() + "' ");
		sql.append(", " + bill.getTotal() + " ");
		sql.append(", " + bill.getQuantity() + " ");
		sql.append(", '" + bill.getNote() + "' ");
		sql.append(", " + bill.getBillDate() + "); ");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public long getIdLastBill() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bill; ");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}

	public int addBillDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO billdetail ");
		sql.append("( ");
		sql.append("	id_product, ");
		sql.append("	id_bill, ");
		sql.append("	quantity, ");
		sql.append("	total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	" + billDetail.getId_product() + ", ");
		sql.append("	" + billDetail.getId_bill() + ", ");
		sql.append("	" + billDetail.getQuantity() + ", ");
		sql.append("	" + billDetail.getTotal() + " ");
		sql.append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public double totalIn1month() {
		String sql = "SELECT SUM(total) FROM bill WHERE billDate BETWEEN DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 30 DAY) AND CURRENT_TIMESTAMP";
		double total = _jdbcTemplate.queryForObject(sql, Double.class);
		return total;
	}
	
	public List<Bill> billIn1Week(){
		String sql = "SELECT * FROM bill WHERE billDate BETWEEN DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 7 DAY) AND CURRENT_TIMESTAMP";
		List<Bill> listBill = _jdbcTemplate.query(sql,new BillMapper());
		return listBill;
	}
}
