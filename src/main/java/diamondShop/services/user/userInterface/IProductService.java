package diamondShop.services.user.userInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.ProductDto;

@Service
public interface IProductService {
	public ProductDto getProductById(long id);
	public List<ProductDto> getProductByCId(int id);
}
