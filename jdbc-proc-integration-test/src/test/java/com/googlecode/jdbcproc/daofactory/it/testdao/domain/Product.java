package com.googlecode.jdbcproc.daofactory.it.testdao.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author dvponomarev, 31.01.2020
 */
public class Product {

    private long        id;
    private String      name;
    private ProductType type;


    //@formatter:off
    @Id
    @Column(name = "product_id")
    public long getId()        { return id; }
    public void setId(long id) { this.id = id;}

    @Column(name = "name")
    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "type")
    public ProductType getType()          { return type; }
    public void setType(ProductType type) { this.type = type; }
    //@formatter:on

}