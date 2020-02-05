package com.googlecode.jdbcproc.daofactory.it.testdao.dao;

import com.googlecode.jdbcproc.daofactory.annotation.AStoredProcedure;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.Product;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.ProductForUpload;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.ProductType;

import java.util.List;

/**
 * For <b>enum</b> testing.
 *
 * @author dvponomarev, 31.01.2020
 */
public interface IProductDao {

    @AStoredProcedure(name = "create_product1")
    void createProduct(String name, ProductType productType);

    @AStoredProcedure(name = "create_product2")
    void createProduct(Product product);

    @AStoredProcedure(name = "get_product_by_id")
    Product getProduct(long id);

    @AStoredProcedure(name = "get_product_type_by_id")
    ProductType getProductType(long id);

    @AStoredProcedure(name = "get_products")
    List<Product> getProducts();

    @AStoredProcedure(name = "get_products")
    Iterable<Product> getProducts2();

    @AStoredProcedure(name = "upload_products")
    void uploadProducts(List<ProductForUpload> products);

}
