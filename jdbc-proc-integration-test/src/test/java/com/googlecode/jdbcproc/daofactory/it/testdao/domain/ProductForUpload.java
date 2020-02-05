package com.googlecode.jdbcproc.daofactory.it.testdao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author dvponomarev, 04.02.2020
 */
@Entity(name = "products")
public class ProductForUpload {

    private String      name;
    private ProductType type;


    //@formatter:off
    @Column(name = "name")
    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "type")
    public ProductType getType()          { return type; }
    public void setType(ProductType type) { this.type = type; }
    //@formatter:on

}
