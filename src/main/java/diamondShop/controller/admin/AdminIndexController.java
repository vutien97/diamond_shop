package diamondShop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminIndexController extends BaseAdminController{

	@RequestMapping(value = "admin/admin-index")
	public ModelAndView index() {
		_mavShare.setViewName("admin/admin-index");
		return _mavShare;
	}
}
