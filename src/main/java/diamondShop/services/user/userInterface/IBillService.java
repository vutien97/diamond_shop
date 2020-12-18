package diamondShop.services.user.userInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;
import diamondShop.entites.Bill;
import diamondShop.entites.BillDetail;
@Service
public interface IBillService {
	public int addBill(Bill bill);
	public List<Bill> listBillIn1Week();
	public void addBillDetail(HashMap<Long, CartDto> cart);
	public List<Bill> billIn1WeekPaginate(int start, int billIn1Page);
	public List<Bill> getBillByUserEmail(String email);
	public List<BillDetail> getBillDetailByBillId(long id);
	public int updateBill(Bill bill);
	public List<Bill> listBill();
	public List<Bill> listBillPaginate(int start, int billIn1Page);
	public List<Bill> getBillByStatus();
	public List<Bill> getBillByStatusPaginate(int start, int billIn1Page);
	public Bill getBillById(long id);
	public List<Bill> getListBillBySearchEmail(String search);
}
