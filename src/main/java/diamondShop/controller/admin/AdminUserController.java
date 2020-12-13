package diamondShop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.User;
import diamondShop.services.user.AccountServiceImpl;

@Controller
public class AdminUserController extends BaseAdminController{
	@Autowired
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	
	@RequestMapping(value = "admin/user", method = RequestMethod.GET)
	public ModelAndView listUser() {
		_mavShare.setViewName("admin/user/user");
		_mavShare.addObject("list_user", accountServiceImpl.getListUserPaginate(0, 10));
		_mavShare.addObject("totalItem", (accountServiceImpl.getAllUser().size() / 10));
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/user/{page}", method = RequestMethod.GET)
	public ModelAndView listUser(@PathVariable int page) {
		_mavShare.setViewName("admin/user/user");
		_mavShare.addObject("list_user", accountServiceImpl.getListUserPaginate((page - 1) * 10, 10));
		_mavShare.addObject("totalItem", (accountServiceImpl.getAllUser().size() / 10));
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/user/delete/{id}")
	public String deleteProduct(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		User user = accountServiceImpl.getUserById(id);
		accountServiceImpl.deleteUser(user);
		return "redirect:" + request.getHeader("Referer");
	}
}
