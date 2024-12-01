/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Storerooms;

import Model.Mapper.Mapper;
import java.sql.Date;

/**
 *
 * @author carlo
 */
public class StoreroomsMapper implements Mapper<Storerooms,StoreroomsDTO> {

    @Override
    public StoreroomsDTO toDto(Storerooms ent) {
        return new StoreroomsDTO(
                ent.getIdProduccion(), 
                ent.getIdQuantity(), 
                Date.valueOf(ent.getEntryDate()),
                Date.valueOf(ent.getDepartureDate()),
                ent.isAlert()
        );
    }

    @Override
    public Storerooms toEnt(StoreroomsDTO dto) {
        return new Storerooms(
                dto.getIdProduccion(), 
                dto.getIdQuantity(), 
                dto.isAlert()
        );
    }
    
}
