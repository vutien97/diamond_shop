package diamondShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import diamondShop.entites.Product;
import diamondShop.entites.mapper.ProductMapper;

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
		sql.append(", p.quantity ");
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

	public List<Product> getHighlightProduct() {
		String sql = SqlProductQuery(NO, YES);
		List<Product> listProductDto = new ArrayList<Product>();
		listProductDto = _jdbcTemplate.query(sql, new ProductMapper());
		return listProductDto;
	}

	public List<Product> getNewProduct() {
		String sql = SqlProductQuery(YES, NO);
		List<Product> listProductDto = new ArrayList<Product>();
		listProductDto = _jdbcTemplate.query(sql, new ProductMapper());
		return listProductDto;
	}

	public List<Product> getListProduct() {
		String sql = SqlListProduct();
		List<Product> listProductDto = new ArrayList<Product>();
		listProductDto = _jdbcTemplate.query(sql, new ProductMapper());
		return listProductDto;
	}

	public List<Product> getListProductByCategoryId(int id) {
		String sql = SqlProductByCategoryIdQuery(id).toString();
		List<Product> listProductDto = new ArrayList<Product>();
		listProductDto = _jdbcTemplate.query(sql, new ProductMapper());
		return listProductDto;
	}

	public List<Product> getListProductPaginate(int id, int start, int totalProductIn1Page) {
		String sql = SqlProductPaginate(id, start, totalProductIn1Page);
		List<Product> listProductDto = new ArrayList<Product>();
		listProductDto = _jdbcTemplate.query(sql, new ProductMapper());
		return listProductDto;
	}

	private String SqlProductByIdQuery(long id) {
		StringBuffer sql = SqlQuery();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id =  " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}

	public List<Product> getProductById(long id) {
		String sql = SqlProductByIdQuery(id);
		List<Product> productDto = _jdbcTemplate.query(sql, new ProductMapper());
		return productDto;
	}

	public Product findProductById(long id) {
		String sql = SqlProductByIdQuery(id);
		Product productDto = _jdbcTemplate.queryForObject(sql, new ProductMapper());
		return productDto;
	}

	public int updateProduct(Product product) {
		String sql = "UPDATE `products` SET `updated_at` = '" + product.getUpdated_at() + "', `quantity` = '" + product.getQuantity() + "' WHERE `products`.`id` = " + product.getId_product();
		
		int update = _jdbcTemplate.update(sql);
		return update;
	}
}
