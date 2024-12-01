/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Crops;

import Model.Mapper.Mapper;
import java.sql.Date;

/**
 *
 * @author Johel M
 */
public class CropMapper implements Mapper<Crop,CropDTO>{

    @Override
    public CropDTO toDto(Crop ent) {
        return new CropDTO(
                ent.getId(), 
                ent.getName(), 
                ent.getType(), 
                ent.getArea(), 
                ent.getState(),
                Date.valueOf(ent.getSowingDate()), 
                Date.valueOf(ent.getHarvestDate())
        );
    }

    @Override
    public Crop toEnt(CropDTO dto) {
        Date SowingDate = dto.getSowingDate();
        Date HarvestDate = dto.getHarvestDate();
        return new Crop(
                dto.getId(), 
                dto.getName(), 
                dto.getType(), 
                dto.getArea(), 
                dto.getState(), 
                SowingDate.toLocalDate(), 
                HarvestDate.toLocalDate());
    }
    
}
