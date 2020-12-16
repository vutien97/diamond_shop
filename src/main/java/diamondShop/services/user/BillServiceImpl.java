package diamondShop.services.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.BillDao;
import diamondShop.dto.CartDto;
import diamondShop.entites.Bill;
import diamondShop.entites.BillDetail;
import diamondShop.services.user.userInterface.IBillService;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	BillDao billDao = new BillDao();

	public int addBill(Bill bill) {

		return billDao.addBill(bill);
	}

	public void addBillDetail(HashMap<Long, CartDto> cart) {
		long idBill = billDao.getIdLastBill();

		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDao.addBillDetail(billDetail);
		}
	}

	public List<Bill> in1Week() {
		return billDao.billIn1Week();
	}

	@Override
	public List<Bill> billIn1WeekPaginate(int start, int billIn1Page) {
		// TODO Auto-generated method stub
		return billDao.billIn1WeekPaginate(start, billIn1Page);
	}

	@Override
	public List<Bill> getBillByUserEmail(String email) {
		// TODO Auto-generated method stub
		return billDao.getBillByUserEmail(email);
	}

	@Override
	public List<BillDetail> getBillDetailByBillId(long id) {
		// TODO Auto-generated method stub
		return billDao.getBillDetailByBillId(id);
	}

	@Override
	public int updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDao.updateBill(bill);
	}

	@Override
	public List<Bill> getBillByStatus() {
		// TODO Auto-generated method stub
		return billDao.getBillByStatus();
	}

	@Override
	public List<Bill> listBill() {
		// TODO Auto-generated method stub
		return billDao.listBill();
	}

	@Override
	public List<Bill> listBillPaginate(int start, int billIn1Page) {
		// TODO Auto-generated method stub
		return billDao.listBillPaginate(start, billIn1Page);
	}

	@Override
	public List<Bill> getBillByStatusPaginate(int start, int billIn1Page) {
		// TODO Auto-generated method stub
		return billDao.getBillByStatusPaginate(start, billIn1Page);
	}

	public Bill getBillById(long id) {
		// TODO Auto-generated method stub
		return billDao.getBillById(id);
	}

	@Override
	public List<Bill> getListBillByEmail(String search) {
		// TODO Auto-generated method stub
		return billDao.getListBillByEmail(search);
	}
	
	

}
