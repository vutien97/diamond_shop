package diamondShop.services.user.userInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;
import diamondShop.entites.Product;

@Service
public interface IProductService {
	public Product getProductById(long id);
	public List<Product> getProductByCId(int id);
	public void updateProduct(HashMap<Long, CartDto> cart);
}
