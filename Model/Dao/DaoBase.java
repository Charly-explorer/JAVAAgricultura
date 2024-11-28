package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author carlo
 */
public abstract class  DaoBase <Dto> {
    protected Connection connection;

    public DaoBase(Connection connection) {
        this.connection = connection;
    }
    
    public abstract boolean create(Dto dto) throws SQLException;
    public abstract Dto read(Object id) throws SQLException;
    public abstract List<Dto> readAll() throws SQLException;
   
}
