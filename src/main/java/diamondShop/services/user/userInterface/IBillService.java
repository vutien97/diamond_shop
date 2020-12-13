package diamondShop.services.user.userInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;
import diamondShop.entites.Bill;
@Service
public interface IBillService {
	public int addBill(Bill bill);
	public List<Bill> in1Week();
	public void addBillDetail(HashMap<Long, CartDto> cart);
	public List<Bill> billIn1WeekPaginate(int start, int billIn1Page);
}
