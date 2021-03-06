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
	public String adminLogin(HttpSession session, HttpServletRequest request, @ModelAttribute("user") User user) {
		if (user.getEmail() == "" || user.getPassword() == "") {
			_mavShare.addObject("statusLogin", "Đăng nhập thất bại!");
			return "redirect:" + request.getHeader("Referer");
		} else {
			user = adminAccountServiceImpl.findAdminByLogin(user);
			if (user != null) {
				// _mavShare.setViewName("redirect:/admin/admin-index");
				session.setAttribute("AdminLoginInfo", user);
				request.getSession().setMaxInactiveInterval(60 * 60);
				return "redirect:/admin/admin-index";
			} else {
				_mavShare.addObject("statusAdminLogin", "Đăng nhập thất bại!");
				return "redirect:" + request.getHeader("Referer");
			}
		}
	}

	@RequestMapping(value = "/admin-logout", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("AdminLoginInfo");
		_mavShare.setViewName("user/index");
		return "redirect:/trang-chu";
	}

}
