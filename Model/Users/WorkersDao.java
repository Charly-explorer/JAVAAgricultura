package Model.Users;

import Model.Dao.DaoAll;
import Model.Dao.DaoBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author carlo
 */
public class WorkersDao extends DaoAll<WorkersDTO> {

    public WorkersDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean update(WorkersDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(WorkersDTO dto) throws SQLException {
 if (dto == null || !validatePk(dto.getId()) ) {
     return false;
 }
 String query = "Call CustomerCreate(?,?,?,?,?)";
 try (PreparedStatement stmt = connection.prepareStatement(query)) 
     stmt.setString(1, dto.getId());
     stmt.setString(2, dto.getName());
     stmt.setDate(3, dto.getBirthDate());
     stmt.setString(4, dto.getPhone());
     stmt.setString(5, dto.getEmail());
     return stmt.executeUpdate() > 0;
 }    }

    @Override
    public WorkersDTO read(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<WorkersDTO> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public boolean validatePk(Object id) throws SQLException {
     return read(id) == null;
 }

}
