package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author carlo
 * @param <Dto>
 */
public abstract class DaoDelete <Dto> extends DaoBase<Dto>{

    public DaoDelete(Connection connection) {
        super(connection);
    }
     public abstract boolean delete(Object id) throws SQLException;
}
