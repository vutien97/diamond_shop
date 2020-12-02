package diamondShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.User;

@Controller
public class UserController extends BaseController {
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {
		_mavShare.setViewName("user/account/register");
		_mavShare.addObject("user", new User());

		return _mavShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") User user) {

		return _mavShare;
	}
}
