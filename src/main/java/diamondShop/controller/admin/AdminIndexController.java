package diamondShop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.services.admin.adminInterface.AdminHomeServiceImpl;

@Controller
public class AdminIndexController extends BaseAdminController {
	@Autowired
	AdminHomeServiceImpl adminHomeServiceImpl = new AdminHomeServiceImpl();

	@RequestMapping(value = "admin/admin-index")
	public ModelAndView index() {

		_mavShare.setViewName("admin/admin-index");
		_mavShare.addObject("userIn1Month", adminHomeServiceImpl.getListUserIn1Month());
		_mavShare.addObject("totalIn1Month", adminHomeServiceImpl.totalIn1month());
		_mavShare.addObject("billIn1Week", adminHomeServiceImpl.in1Week());
		return _mavShare;
	}
}
