package diamondShop.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.User;
import diamondShop.services.user.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {
		_mavShare.setViewName("user/account/register");
		_mavShare.addObject("user", new User());

		return _mavShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") User user) {
		int count = accountServiceImpl.addAccount(user);
		if (count > 0) {
			_mavShare.addObject("status", "Đăng ký thành công!");
		} else {
			_mavShare.addObject("status", "Đăng ký thất bại!");
		}
		_mavShare.setViewName("user/account/register");
		return _mavShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session,@ModelAttribute("user") User user) {
		boolean check = accountServiceImpl.findUserByLogin(user);
		if (check) {
			_mavShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		} else {
			_mavShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
		return _mavShare;
	}

}
