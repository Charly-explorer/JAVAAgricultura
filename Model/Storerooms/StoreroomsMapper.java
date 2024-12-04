/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Storerooms;

import Model.Mapper.Mapper;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class StoreroomsMapper implements Mapper<Storerooms,StoreroomsDTO> {

    @Override
    public StoreroomsDTO toDto(Storerooms ent) {
        return new StoreroomsDTO(
                ent.getId(),
                ent.getIdProduccion(), 
                ent.getIdQuantity(), 
                validateDate(ent.getEntryDate()),
                validateDate(ent.getDepartureDate()),
                ent.isAlert()
        );
    }
    public Date validateDate(LocalDate date){
        if(date == null)
            return null;
        return Date.valueOf(date);
    }

    @Override
    public Storerooms toEnt(StoreroomsDTO dto) {
        Date EntryDate = dto.getEntryDate();
        Date DepartureDate = dto.getDepartureDate();
        
        return new Storerooms(
                dto.getIdProduccion(), 
                dto.getIdQuantity(), 
                EntryDate.toLocalDate(),
               DepartureDate.toLocalDate(),
                dto.isAlert()
        );
    }
    
}
