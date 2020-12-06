package diamondShop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.services.user.HomeServiceImpl;

@Controller
public class BaseAdminController {
	@Autowired
	HomeServiceImpl _homeServiceImpl;
	public ModelAndView _mavShare = new ModelAndView();

}
