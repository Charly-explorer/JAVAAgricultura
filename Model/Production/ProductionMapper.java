/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Production;

import Model.Crops.CropDao;
import Model.Crops.CropMapper;
import Model.Mapper.Mapper;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johel M
 */
public class ProductionMapper implements Mapper<Production, ProductionDTO> {

    @Override
    public ProductionDTO toDto(Production ent) {
        return new ProductionDTO(
                ent.getId(),
                ent.getCrop().getId(),
                Date.valueOf(ent.getDate()),
                ent.getAmount(),
                ent.getAmount2(),
                ent.getDestiny()
        );
    }

    @Override
    public Production toEnt(ProductionDTO dto) {
        Date date = dto.getDate();
        try {
            return new Production(
                    dto.getId(),
                    new CropMapper().toEnt(new CropDao(DataBase.DataBase.
                            getConnetion()).read(dto.getCrop())),
                    date.toLocalDate(),
                    dto.getAmount(),
                    dto.getAmount2(),
                    dto.getDestiny()
            );
        } catch (SQLException ex) {
            Logger.getLogger(ProductionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
