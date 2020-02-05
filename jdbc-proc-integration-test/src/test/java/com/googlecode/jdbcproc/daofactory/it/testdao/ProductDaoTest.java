package com.googlecode.jdbcproc.daofactory.it.testdao;

import com.googlecode.jdbcproc.daofactory.it.DatabaseAwareTest;
import com.googlecode.jdbcproc.daofactory.it.testdao.dao.IProductDao;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.Product;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.ProductForUpload;
import com.googlecode.jdbcproc.daofactory.it.testdao.domain.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoTest extends DatabaseAwareTest {

    public void test1() {
        theProductDao.createProduct("Apple", ProductType.HARD);

        final List<Product> products = theProductDao.getProducts();
        assertNotNull(products);
        assertEquals(1, products.size());
        final long id = products.get(0).getId();
        assertTrue(id > 0);
        assertEquals("Apple", products.get(0).getName());
        assertEquals(ProductType.HARD, products.get(0).getType());

        final Product product = theProductDao.getProduct(id);
        assertNotNull(product);
        assertEquals(id, product.getId());
        assertEquals("Apple", product.getName());
        assertEquals(ProductType.HARD, product.getType());

        final Iterable<Product> products2 = theProductDao.getProducts2();
    }

    public void test2() {
        final Product product = new Product();
        assertEquals(0, product.getId());
        product.setName("Samsung");
        product.setType(ProductType.HARD);
        theProductDao.createProduct(product);
        assertTrue(product.getId() > 0);

        final List<Product> products = theProductDao.getProducts();
        assertNotNull(products);
        assertEquals(1, products.size());
        final long id = products.get(0).getId();
        assertTrue(id > 0);
        assertEquals(product.getName(), products.get(0).getName());
        assertEquals(product.getType(), products.get(0).getType());

        final ProductType productType = theProductDao.getProductType(id);
        assertNotNull(productType);
        assertEquals(ProductType.HARD, productType);
    }

    public void test3() {
        final List<ProductForUpload> products = new ArrayList<>();
        {
            final ProductForUpload product = new ProductForUpload();
            product.setName("Google");
            product.setType(ProductType.SOFT);
            products.add(product);
        }
        {
            final ProductForUpload product = new ProductForUpload();
            product.setName("Samsung");
            product.setType(ProductType.HARD);
            products.add(product);
        }

        theProductDao.uploadProducts(products);

        final List<Product> products2 = theProductDao.getProducts();
        assertNotNull(products2);
        assertEquals(2, products2.size());
        final Product product1 = products2.get(0);
        final Product product2 = products2.get(1);
        assertTrue(product1.getId() > 0);
        assertEquals("Google", product1.getName());
        assertEquals(ProductType.SOFT, product1.getType());
        assertTrue(product2.getId() > 0);
        assertEquals("Samsung", product2.getName());
        assertEquals(ProductType.HARD, product2.getType());
    }


    public void setProductDao(IProductDao aCompanyDao) {
        theProductDao = aCompanyDao;
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{
                getSpringConfig("datasource.xml")
                , getSpringConfig("factory.xml")
                , "/spring/test-dao.xml"
        };
    }

    protected IProductDao theProductDao;

}
