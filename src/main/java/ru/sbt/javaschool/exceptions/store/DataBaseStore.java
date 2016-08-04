package ru.sbt.javaschool.exceptions.store;

import java.sql.SQLException;
import java.util.List;

/**
 * @author evstafiev
 */
public class DataBaseStore implements Store {

    private final Db db;

    public DataBaseStore(Db db) {
        this.db = db;
    }

    @Override
    public void save(String t) {
        try (Db temp = db) {
            temp.insert(t);
        } catch (SQLException ex) {
            throw new DbException("Exception from DataBaseStore, caused by SQLException when saving. Don't worry, be happy!", ex);
        }
    }

    @Override
    public List<String> getAll() {
        try (Db temp = db) {
            return temp.selectAll();
        } catch (SQLException ex) {
            throw new DbException("Exception from DataBaseStore, caused by SQLException when getting. Don't worry, be happy!", ex);
        }
    }

}
