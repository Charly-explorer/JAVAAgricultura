package Model.Storerooms;

import Model.Dao.DaoUpdate;
import Model.Users.UsersDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class StoreroomsDAO extends DaoUpdate<StoreroomsDTO> {

    public StoreroomsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean update(StoreroomsDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call StoreroomsUpdate(?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getIdProduccion());
            stmt.setDouble(2, dto.getIdQuantity());
            stmt.setDate(3, (Date) dto.getEntryDate());
            stmt.setDate(4, (Date) dto.getDepartureDate());
            stmt.setBoolean(5, dto.isAlert());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean create(StoreroomsDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getIdProduccion())) {
            return false;
        }
        String query = "Call storeroomsCreate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
             stmt.setInt(1, dto.getIdProduccion());
            stmt.setDouble(2, dto.getIdQuantity());
            stmt.setDate(3, (Date) dto.getEntryDate());
            stmt.setDate(4, (Date) dto.getDepartureDate());
            stmt.setBoolean(5, dto.isAlert());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public StoreroomsDTO read(Object id) throws SQLException {
if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call StoreroomsRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new StoreroomsDTO(
                            rs.getInt(1),
                            rs.getDouble(2),
                             rs.getDate(3),
                             rs.getDate(4),
                            rs.getBoolean(5));

                }
            }
        }
        return null;    }

    @Override
    public List<StoreroomsDTO> readAll() throws SQLException {
String query = "Call CustomerReadAll()";
        List<StoreroomsDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new StoreroomsDTO(
                           rs.getInt(1),
                            rs.getDouble(2),
                             rs.getDate(3),
                             rs.getDate(4),
                            rs.getBoolean(5)));

                }
            }
        }
        return list;    }
    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
}
