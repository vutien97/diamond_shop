package diamondShop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.User;
import diamondShop.services.admin.AdminAccountServiceImpl;

@Controller
public class AdminAccountController extends BaseAdminController {
	@Autowired
	AdminAccountServiceImpl adminAccountServiceImpl = new AdminAccountServiceImpl();

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public ModelAndView login() {
		_mavShare.setViewName("admin/account/login");
		_mavShare.addObject("user", new User());
		return _mavShare;
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	public ModelAndView adminLogin(HttpSession session, @ModelAttribute("user") User user) {
		user = adminAccountServiceImpl.findAdminByLogin(user);
		if (user != null) {
			_mavShare.setViewName("redirect:trang-chu");
			session.setAttribute("AdminLoginInfo", user);
		} else {
			_mavShare.addObject("statusAdminLogin", "Đăng nhập thất bại!");
		}
		return _mavShare;
	}
	
	@RequestMapping(value = "/admin-logout", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("AdminLoginInfo");
		_mavShare.setViewName("user/index");
		return "redirect:/trang-chu" ;
	}

}
