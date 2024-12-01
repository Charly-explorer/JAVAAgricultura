/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Production;

import Model.Dao.DaoBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johel M
 */
public class ProductionDao extends DaoBase<ProductionDTO>{

    public ProductionDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(ProductionDTO dto) throws SQLException {
        if(dto==null){
            return false;
        }
        String query = "Call ProductionCreate(?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getCrop());
            stmt.setDate(2, dto.getDate());
            stmt.setInt(3, dto.getAmount());
            stmt.setString(4, dto.getQuality());
            stmt.setString(5, dto.getDestiny());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public ProductionDTO read(Object id) throws SQLException {
        if(id==null){
            return null;
        }
        String query = "Call ProductionRead(?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new ProductionDTO(
                            rs.getInt(1), 
                            rs.getInt(2), 
                            rs.getDate(3), 
                            rs.getInt(4), 
                            rs.getString(5), 
                            rs.getString(6)
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<ProductionDTO> readAll() throws SQLException {
        String query = "Call ProductionReadAll()";
        ArrayList<ProductionDTO> list = new ArrayList();
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    list.add(new ProductionDTO(
                            rs.getInt(1), 
                            rs.getInt(2), 
                            rs.getDate(3), 
                            rs.getInt(4), 
                            rs.getString(5), 
                            rs.getString(6)
                    )) ;
                }
            }
        }
        return list;
    }
    
}
