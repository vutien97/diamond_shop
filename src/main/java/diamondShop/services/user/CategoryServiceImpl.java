package diamondShop.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.ProductDao;
import diamondShop.entites.Product;
import diamondShop.services.user.userInterface.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductByCategoryId(int id_category) {
		return productDao.getListProductByCategoryId(id_category);
	}

	@Override
	public List<Product> getDataProductPaginate(int id, int start, int totalProductIn1Page) {
		List<Product> listProductDto = productDao.getListProductByCIdPaginate(id, start, totalProductIn1Page);
		return listProductDto;
	}

}
