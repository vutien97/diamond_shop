package diamondShop.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.ProductDao;
import diamondShop.dto.ProductDto;
import diamondShop.services.user.userInterface.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductDto> getProductByCategoryId(int id_category) {
		return productDao.getListProductByCategoryId(id_category);
	}

	@Override
	public List<ProductDto> getDataProductPaginate(int id, int start, int totalProductIn1Page) {
		List<ProductDto> listProductDto = productDao.getListProductPaginate(id, start, totalProductIn1Page);
		return listProductDto;
	}

}
