package diamondShop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.dto.PaginateDto;
import diamondShop.services.user.CategoryServiceImpl;
import diamondShop.services.user.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceImpl _categoryServiceImpl;
	@Autowired
	private PaginateServiceImpl _paginateServiceImpl;
	
	private int totalProductIn1Page = 9;

	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {

		_mavShare.setViewName("user/product/category");
		_mavShare.addObject("listProductByC_Id", _categoryServiceImpl.getProductByCategoryId(Integer.parseInt(id)));
		
		//Lay size cua list productByCategory truyen vao totalData
		int totalData = _categoryServiceImpl.getProductByCategoryId(Integer.parseInt(id)).size();
		PaginateDto paginateDto = _paginateServiceImpl.getInforPaginate(totalData, totalProductIn1Page, 1);
		_mavShare.addObject("productPaginate",
				_categoryServiceImpl.getDataProductPaginate(Integer.parseInt(id), paginateDto.getStart(), totalProductIn1Page));
		_mavShare.addObject("paginateInfo", paginateDto);
		_mavShare.addObject("id_category", id);
		return _mavShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {

		_mavShare.setViewName("user/product/category");
		_mavShare.addObject("listProductByC_Id", _categoryServiceImpl.getProductByCategoryId(Integer.parseInt(id)));
		
		//Lay size cua list productByCategory truyen vao totalData
		int totalData = _categoryServiceImpl.getProductByCategoryId(Integer.parseInt(id)).size();
		PaginateDto paginateDto = _paginateServiceImpl.getInforPaginate(totalData, 9, Integer.parseInt(currentPage));
		_mavShare.addObject("productPaginate",
				_categoryServiceImpl.getDataProductPaginate(Integer.parseInt(id), paginateDto.getStart(), totalProductIn1Page));
		_mavShare.addObject("paginateInfo", paginateDto);
		_mavShare.addObject("id_category", id);
		return _mavShare;
	}
}
