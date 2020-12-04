package diamondShop.services.user.userInterface;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;
import diamondShop.entites.Bill;
@Service
public interface IBillService {
	public int addBill(Bill bill);

	public void addBillDetail(HashMap<Long, CartDto> cart);
}
