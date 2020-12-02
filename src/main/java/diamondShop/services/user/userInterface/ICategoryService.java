package diamondShop.services.user.userInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> getProductByCategoryId(int id_category);
	public List<ProductDto> getDataProductPaginate(int id, int start, int totalPage);
}
