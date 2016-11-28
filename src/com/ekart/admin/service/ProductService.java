package com.ekart.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.ekart.user.entity.Product;
import com.ekart.user.entity.ProductImage;
import com.ekart.user.service.GenericService;

public interface ProductService extends GenericService<Product>{
    public List<Product> getByCategory() throws SQLException;
    public int insertImage(Product product,List<ProductImage> productImages) throws SQLException;

    

}
