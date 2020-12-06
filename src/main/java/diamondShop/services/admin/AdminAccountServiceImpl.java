package diamondShop.services.admin;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.UserDao;
import diamondShop.entites.User;
import diamondShop.services.admin.adminInterface.IAdminAccountService;

@Service
public class AdminAccountServiceImpl implements IAdminAccountService {
	@Autowired
	UserDao userDao = new UserDao();

	@Override
	public User findAdminByLogin(User user) {
		String pass = user.getPassword();
		user = userDao.getUserByLogin(user);
		if (user != null) {
			// Check password
			if (BCrypt.checkpw(pass, user.getPassword()) && user.isRole()) {
				return user;
			} else {
				return null;
			}
		}
		return null;
	}

}
