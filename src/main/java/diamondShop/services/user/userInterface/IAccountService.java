package diamondShop.services.user.userInterface;

import org.springframework.stereotype.Service;

import diamondShop.entites.User;

@Service
public interface IAccountService {
	public int addAccount(User user);
	public boolean findUserByLogin(User user);
}
