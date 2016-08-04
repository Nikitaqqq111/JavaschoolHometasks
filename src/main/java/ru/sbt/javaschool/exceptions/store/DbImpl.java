package ru.sbt.javaschool.exceptions.store;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author evstafiev
 */
public class DbImpl implements Db {

    private final List<String> listOfVarchar2FromDb;

    private final boolean isBadConnectionWhenInsert;

    private final boolean isBadConnectionWhenSelect;

    public DbImpl(List<String> listOfVarchar2FromDb, boolean isBadConnectionWhenInsert, boolean isBadConnectionWhenSelect) {
        this.listOfVarchar2FromDb = listOfVarchar2FromDb;
        this.isBadConnectionWhenInsert = isBadConnectionWhenInsert;
        this.isBadConnectionWhenSelect = isBadConnectionWhenSelect;
    }

    @Override
    public void insert(String line) throws SQLException {
        if (isBadConnectionWhenInsert) {
            throw new SQLException();
        }
        listOfVarchar2FromDb.add(line);
    }

    @Override
    public List<String> selectAll() throws SQLException {
        if (isBadConnectionWhenSelect) {
            throw new SQLException();
        }
        return listOfVarchar2FromDb;
    }

    @Override
    public void close() throws RuntimeException {
        if (isBadConnectionWhenInsert && isBadConnectionWhenSelect) {
            throw new RuntimeException();
        }
    }

}
