package diamondShop.services.user.userInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.entites.Product;

@Service
public interface ICategoryService {
	public List<Product> getProductByCategoryId(int id_category);
	public List<Product> getDataProductPaginate(int id, int start, int totalPage);
}
