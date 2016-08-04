package ru.sbt.javaschool.exceptions.store;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author evstafiev
 */
public interface Db extends AutoCloseable {

    void insert(String line) throws SQLException;

    List<String> selectAll() throws SQLException;
    
    void close() throws RuntimeException;

}
