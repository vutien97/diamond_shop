package diamondShop.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.ProductDao;
import diamondShop.dto.ProductDto;
import diamondShop.services.user.userInterface.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductDao productDao = new ProductDao();

	@Override
	public ProductDto getProductById(long id) {
		List<ProductDto> listProductDto = productDao.getProductById(id);
		return listProductDto.get(0);
	}

	@Override
	public List<ProductDto> getProductByCId(int id) {
		return productDao.getListProductByCategoryId(id);
	}

}
