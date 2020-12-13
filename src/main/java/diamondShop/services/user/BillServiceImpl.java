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

}
