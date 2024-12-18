package Model.Workers;

import Model.Dao.DaoAll;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class WorkersDao extends DaoAll<WorkersDTO> {
    
    private static int cont = 3;

    public WorkersDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean update(WorkersDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call WorkersUpdate(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getTelephone()); // Teléfono
            stmt.setString(2, dto.getEmail());     // Email
            stmt.setString(3, dto.getPosition()); // Posición
            stmt.setString(4, dto.getSchedule()); // Horario
            stmt.setDouble(5, dto.getSalary());
            stmt.setString(6, dto.getIdCard());// Salario
            return stmt.executeUpdate() > 0; 
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call WorkersDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;
        }
    }
    

    @Override
    public boolean create(WorkersDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getIdCard())) {
            return false;
        }
        String query = "Call WorkersCreate(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {           
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getLastName1());
            stmt.setString(4, dto.getLastName2());
            stmt.setString(5, dto.getTelephone());
            stmt.setString(6, dto.getEmail());     
            stmt.setString(7, dto.getPosition());
            stmt.setString(8, dto.getSchedule());            
            stmt.setDouble(9, dto.getSalary());
            stmt.setString(10, dto.getIdCard());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public WorkersDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call WorkersRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new WorkersDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getDouble(10));

                }
            }
        }
        return null;
    }

    @Override
    public List<WorkersDTO> readAll() throws SQLException {
        String query = "Select * from workers";
        List<WorkersDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new WorkersDTO(
                     rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getDouble(10)));
                    
                }
            }
        }
        return list;
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }

}
