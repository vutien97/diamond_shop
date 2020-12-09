package diamondShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView index() {

		_mavShare.addObject("slide", _homeServiceImpl.getDataSlide());
		_mavShare.addObject("category", _homeServiceImpl.getDataCategory());
		_mavShare.addObject("product", _homeServiceImpl.getListProduct());
		_mavShare.addObject("new_product", _homeServiceImpl.getNewProduct());
		_mavShare.addObject("highlight", _homeServiceImpl.getHighlightProduct());
		_mavShare.setViewName("user/index");

		return _mavShare;
	}

}
