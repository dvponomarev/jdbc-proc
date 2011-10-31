package com.googlecode.jdbcproc.daofactory.impl.block.impl;

import com.googlecode.jdbcproc.daofactory.impl.block.IResultSetConverterBlock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Collections;

import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.StatementCloser;
import org.springframework.util.Assert;

/**
 * Creates list of entity
 */
public class ResultSetConverterBlockEntityList implements IResultSetConverterBlock {

    public ResultSetConverterBlockEntityList(ResultSetConverterBlockEntity aBlockEntity) {
        theBlockEntity = aBlockEntity;
    }

    public Object convertResultSet(ResultSet aResultSet, StatementCloser aStmt) throws SQLException {
        Assert.notNull(aResultSet, "ResultSet is null");
        LinkedList list = new LinkedList();
        while(aResultSet.next()) {
            Object entity = theBlockEntity.createEntity(aResultSet);
            list.add(entity);
        }
        return Collections.unmodifiableList(list);
    }

    public String toString() {
        return "ResultSetConverterBlockEntityList{" +
                "theBlockEntity=" + theBlockEntity +
                '}';
    }

    private final ResultSetConverterBlockEntity theBlockEntity;
}
