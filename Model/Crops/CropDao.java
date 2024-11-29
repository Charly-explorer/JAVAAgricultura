/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Crops;

import Model.Dao.DaoAll;
import Model.State.CropState;
import Model.State.HarvestedCropState;
import Model.State.LostCropState;
import Model.State.RipenningCropState;
import Model.State.SownCropState;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Johel M
 */
public class CropDao extends DaoAll<CropDTO>{

    public CropDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean update(CropDTO dto) throws SQLException {
        
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        
    }

    @Override
    public boolean create(CropDTO dto) throws SQLException {
        if(dto==null ){
            return false;
        }
        String query="Call CropsCreate(?,?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,dto.getName());
            stmt.setString(2, dto.getType());
            stmt.setString(3, dto.getArea());
            stmt.setString(4, convertStateToString(dto.getState()));
            stmt.setDate(5, dto.getSowingDate());
            stmt.setDate(6, dto.getHarvestDate());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public CropDTO read(Object id) throws SQLException {
        if(id==null || String.valueOf(id).trim().isEmpty()){
            return null;
        }
        String query="Call CropsRead(?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, String.valueOf(id));
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new CropDTO(
                            rs.getInt(1), 
                            rs.getString(2), 
                            rs.getString(3), 
                            rs.getString(4), 
                            convertStateToClass(rs.getString(5)), 
                            rs.getDate(6), 
                            rs.getDate(7)
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<CropDTO> readAll() throws SQLException {
        String query="Call CropsReadAll()";
        ArrayList<CropDTO> list = new ArrayList();
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    list.add(new CropDTO(
                            rs.getInt(1), 
                            rs.getString(2), 
                            rs.getString(3), 
                            rs.getString(4), 
                            convertStateToClass(rs.getString(5)), 
                            rs.getDate(6), 
                            rs.getDate(7)
                    )) ;
                }
            }
        }
        return list;
    }
    
    public CropState convertStateToClass(String state){
        Crop crop = new Crop();
        Map<String,CropState> states = Map.of(
                "H", new HarvestedCropState(crop), 
                "L", new LostCropState(crop), 
                "R", new RipenningCropState(crop), 
                "S", new SownCropState(crop));
        return states.get(state);
    }
    
    public String convertStateToString(CropState state){
        Map<Class<? extends CropState>,String> states = Map.of(
                 HarvestedCropState.class,"H", 
                 LostCropState.class, "L",
                 RipenningCropState.class, "R",
                 SownCropState.class,"S");
        return states.getOrDefault(state.getClass(),"S");
    }
}
