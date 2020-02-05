package com.googlecode.jdbcproc.daofactory.impl.block.impl;

import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.ICallableStatementGetStrategy;
import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.StatementArgument;
import com.googlecode.jdbcproc.daofactory.impl.parameterconverter.IParameterConverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Sets output parameter to entity property
 */
public class EntityPropertySetter {

    public EntityPropertySetter(Method aSetterMethod
            , IParameterConverter aConverter
            , String aParameterName
            , Class aParameterType
            , StatementArgument aStatementArgument
            , int aSqlType
    ) {
        theConverter = aConverter;
        theSetterMethod = aSetterMethod;
        theParameterName = aParameterName;
        theParameterType = aParameterType;
        theSqlType = aSqlType;
        theStatementArgument = aStatementArgument;
    }

    public void fillProperty(Object aEntity, ResultSet aResultSet) throws InvocationTargetException, IllegalAccessException, SQLException {
        Object value = theConverter.getFromResultSet(aResultSet, theParameterName, theParameterType);
        setProperty(aEntity, value);
    }

    public void fillOutputParameter(Object aEntity, ICallableStatementGetStrategy aStmt) throws InvocationTargetException, IllegalAccessException, SQLException {
        Object value = theConverter.getOutputParameter(aStmt, theStatementArgument, theParameterType);
        setProperty(aEntity, value);
    }

    private void setProperty(Object aEntity, Object aValue) throws InvocationTargetException, IllegalAccessException {
        try {
            theSetterMethod.invoke(aEntity, aValue);
        } catch (IllegalArgumentException e) {
            String gettedType = aValue!=null ? aValue.getClass().getSimpleName() : "NULL";
            String argumentType = theSetterMethod.getParameterTypes()[0].getSimpleName();
            throw new IllegalStateException(
                    String.format("Unable to set %s of sql type %d to %s.%s(%s)"
                    , gettedType, theSqlType, aEntity.getClass().getSimpleName(), theSetterMethod.getName(), argumentType), e);
        }
    }

    public String toString() {
        return "EntityPropertySetter{" +
                "theConverter=" + theConverter +
                ", theSetterMethod=" + theSetterMethod +
                ", theParameterName='" + theParameterName + '\'' +
                ", theSqlType=" + theSqlType +
                '}';
    }

    private final IParameterConverter theConverter;
    private final Method theSetterMethod;
    private final String theParameterName;
    private final Class theParameterType;
    private final int theSqlType;
    private final StatementArgument theStatementArgument;
}
