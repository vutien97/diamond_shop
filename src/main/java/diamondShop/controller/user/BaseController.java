package diamondShop.controller.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.services.user.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeServiceImpl;
	public ModelAndView _mavShare = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		_mavShare.addObject("menu", _homeServiceImpl.getDataMenu());
		return _mavShare;
	}
}
