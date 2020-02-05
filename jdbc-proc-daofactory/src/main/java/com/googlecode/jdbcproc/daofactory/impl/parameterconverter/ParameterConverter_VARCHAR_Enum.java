package com.googlecode.jdbcproc.daofactory.impl.parameterconverter;

import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.ICallableStatementGetStrategy;
import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.ICallableStatementSetStrategy;
import com.googlecode.jdbcproc.daofactory.impl.dbstrategy.StatementArgument;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * VARCHAR - Boolean
 */
public class ParameterConverter_VARCHAR_Enum
        implements IParameterConverter<ParameterConverter_VARCHAR_Enum, Enum<?>> {

    public static final Type<ParameterConverter_VARCHAR_Enum> TYPE
            = new Type<ParameterConverter_VARCHAR_Enum>(Types.VARCHAR, Enum.class);

    public void setValue(Enum<?> aValue, ICallableStatementSetStrategy aStmt, StatementArgument aArgument) throws SQLException {
        if (aValue != null) {
            aStmt.setString(aArgument, aValue.name());
        } else {
            aStmt.setString(aArgument, null);
        }
    }

    public Enum<?> getOutputParameter(ICallableStatementGetStrategy aStmt, StatementArgument aParameterName, Class aParameterType) throws SQLException {
        String strValue = aStmt.getString(aParameterName);
        return aStmt.wasNull() ? null : Enum.valueOf(aParameterType, strValue);
    }

    public Enum<?> getFromResultSet(ResultSet aResultSet, String aParameterName, Class aParameterType) throws SQLException {
        String strValue = aResultSet.getString(aParameterName);
        return aResultSet.wasNull() ? null : Enum.valueOf(aParameterType, strValue);
    }

    public Type<ParameterConverter_VARCHAR_Enum> getType() {
        return TYPE;
    }

    public String toString() {
        return "ParameterConverter_VARCHAR_Enum{}";
    }
}
