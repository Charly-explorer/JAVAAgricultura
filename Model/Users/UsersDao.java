package Model.Users;

import Model.Dao.DaoAll;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class UsersDao extends DaoAll<UsersDTO> {

    public UsersDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean update(UsersDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call UsersUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getPassword());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call UsersDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean create(UsersDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getId())) {
            return false;
        }
        String query = "Call UsersCreate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getPassword());

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public UsersDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call UsersRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsersDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3));

                }
            }
        }
        return null;
    }

    @Override
    public List<UsersDTO> readAll() throws SQLException {
        String query = "Call CustomerReadAll()";
        List<UsersDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new UsersDTO(
                           rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)));

                }
            }
        }
        return list;
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
}
