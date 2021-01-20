package diamondShop.services.user;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.UserDao;
import diamondShop.entites.User;
import diamondShop.services.user.userInterface.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserDao userDao = new UserDao();

	public int addAccount(User user) {
		
		if(user.getEmail() == "" || user.getPassword() == "" || user.getDisplay_name() =="") {
			return 0;
		} else {
		// Ma hoa mat khau
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8)));
		return userDao.addUser(user);
		}
	}

	@Override
	public User findUserByLogin(User user) {
		String pass = user.getPassword();
		user = userDao.getUserByLogin(user);
		if (user != null) {
			// Check password
			if (BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public List<User> getListUserPaginate(int start, int totalProductIn1Page) {
		// TODO Auto-generated method stub
		return userDao.getListUserPaginate(start, totalProductIn1Page);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public int updateUser(User user) {
		if(user.getPassword() == "" || user.getDisplay_name() =="") {
			return 0;
		} else {
		// Ma hoa mat khau
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8)));
		return userDao.updateUser(user);
		}
	}

}
