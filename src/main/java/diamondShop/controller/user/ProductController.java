package diamondShop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.Product;
import diamondShop.services.user.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImpl _productServiceImpl;
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{id}"})
	public ModelAndView product(@PathVariable long id) {
		_mavShare.setViewName("user/product/product");
		Product productDto = _productServiceImpl.getProductById(id);
		_mavShare.addObject("productById", productDto);
		_mavShare.addObject("productByCId", _productServiceImpl.getProductByCId(productDto.getId_category()));
		return _mavShare;
	}
}
