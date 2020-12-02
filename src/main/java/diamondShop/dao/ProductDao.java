package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.dto.ProductDto;
import diamondShop.dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlQuery() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.size ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.detail ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("color AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}

	private String SqlProductQuery(boolean new_product, boolean highlight) {
		StringBuffer sql = SqlQuery();
		sql.append("WHERE 1 = 1 ");
		if (new_product) {
			sql.append("AND p.new_product = true ");
		}
		if (highlight) {
			sql.append("AND p.highlight = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highlight) {
			sql.append("LIMIT 6 ");
		}
		return sql.toString();
	}

	private StringBuffer SqlProductByCategoryIdQuery(int id_category) {
		StringBuffer sql = SqlQuery();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category =  " + id_category);
		return sql;
	}

	private String SqlProductPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductByCategoryIdQuery(id);
		sql.append(" LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}

	private String SqlListProduct() {
		StringBuffer sql = SqlQuery();
		return sql.toString();
	}

	public List<ProductDto> getHighlightProduct() {
		String sql = SqlProductQuery(NO, YES);
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProductDto;
	}

	public List<ProductDto> getNewProduct() {
		String sql = SqlProductQuery(YES, NO);
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProductDto;
	}

	public List<ProductDto> getListProduct() {
		String sql = SqlListProduct();
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProductDto;
	}

	public List<ProductDto> getListProductByCategoryId(int id) {
		String sql = SqlProductByCategoryIdQuery(id).toString();
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProductDto;
	}

	public List<ProductDto> getListProductPaginate(int id, int start, int totalProductIn1Page) {
		String sql = SqlProductPaginate(id, start, totalProductIn1Page);
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProductDto;
	}

	private String SqlProductByIdQuery(long id) {
		StringBuffer sql = SqlQuery();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id =  " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}

	public List<ProductDto> getProductById(long id) {
		String sql = SqlProductByIdQuery(id);
		List<ProductDto> productDto = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return productDto;
	}

	public ProductDto findProductById(long id) {
		String sql = SqlProductByIdQuery(id);
		ProductDto productDto = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
		return productDto;
	}
}
