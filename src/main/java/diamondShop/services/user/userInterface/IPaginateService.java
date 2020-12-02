package diamondShop.services.user.userInterface;

import org.springframework.stereotype.Service;

import diamondShop.dto.PaginateDto;

@Service
public interface IPaginateService {
	public PaginateDto getInforPaginate(int total, int limit, int currentPage);
}
