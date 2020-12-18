package diamondShop.services.user;

import org.springframework.stereotype.Service;

import diamondShop.dto.PaginateDto;
import diamondShop.services.user.userInterface.IPaginateService;

@Service
public class PaginateServiceImpl implements IPaginateService {
	public PaginateDto getInforPaginate(int totalData, int limit, int currentPage) {
		PaginateDto paginateDto = new PaginateDto();
		paginateDto.setLimit(limit);
		paginateDto.setTotalPage(SetInforTotalPage(totalData, limit));
		paginateDto.setCurrentPage(CheckCurrentPage(currentPage, paginateDto.getTotalPage()));
		paginateDto.setStart(findStart(currentPage, limit));
		paginateDto.setEnd(findEnd(paginateDto.getStart(), limit, totalData));
		return paginateDto;
	}

	private int findEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : start + limit - 1;
	}

	private int findStart(int currentPage, int limit) {
		return (currentPage - 1) * limit + 1;
	}

	// Lay tong so trang
	private int SetInforTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		// Xet truong hop totalData khong chia het cho limit
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}

	// Kiem tra neu so trang nguoi dung muon den > totalPage
	private int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
