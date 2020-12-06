package diamondShop.services.admin.adminInterface;

import org.springframework.stereotype.Service;

import diamondShop.entites.User;

@Service
public interface IAdminAccountService {
	public User findAdminByLogin(User user);
}
