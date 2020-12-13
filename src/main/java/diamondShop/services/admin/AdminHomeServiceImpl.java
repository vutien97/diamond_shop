package diamondShop.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.BillDao;
import diamondShop.dao.UserDao;
import diamondShop.entites.Bill;
import diamondShop.entites.User;
import diamondShop.services.admin.adminInterface.IAdminHomeService;

@Service
public class AdminHomeServiceImpl implements IAdminHomeService {
	@Autowired
	UserDao userDao = new UserDao();
	@Autowired
	BillDao billDao = new BillDao();

	public List<User> getListUserIn1Month() {
		return userDao.getListUserIn1Month();
	}

	@Override
	public double totalIn1month() {
		return billDao.totalIn1month();
	}

	@Override
	public List<Bill> in1Week() {
		return billDao.billIn1Week();
	}
}
