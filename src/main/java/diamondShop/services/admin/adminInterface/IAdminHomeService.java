package diamondShop.services.admin.adminInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.entites.Bill;
import diamondShop.entites.User;
@Service
public interface IAdminHomeService {
	public List<User> getListUserIn1Month();
	public double totalIn1month();
	public List<Bill> in1Week();
}	
