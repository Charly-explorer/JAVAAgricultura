
package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public abstract class DaoAll<Dto> extends DaoDelete<Dto>{
    
    public DaoAll(Connection connection) {
        super(connection);
    }
    public abstract boolean update(Dto dto) throws SQLException;
    
}
