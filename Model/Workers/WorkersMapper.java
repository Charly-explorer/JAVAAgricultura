/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Workers;

import Model.Mapper.Mapper;

/**
 *
 * @author emma
 */
public class WorkersMapper implements Mapper<Workers,WorkersDTO> {

    @Override
    public WorkersDTO toDto(Workers ent) {
        return new WorkersDTO(
                ent.getIdCard(),//idCard,
                ent.getName(),//name,
                ent.getLastName1(),//lastName1,
                ent.getLastName2(),//lastName2,
                ent.getTelephone(),//telephone,
                ent.getEmail(),//email,
                ent.getPosition(),//position,
                ent.getSchedule(),//schedule,
                ent.getSalary()//Salary
        );
    }

    @Override
    public Workers toEnt(WorkersDTO dto) {
        return new Workers(
                dto.getIdCard(),//idCard,
                dto.getName(),//name,
                dto.getLastName1(),//lastName1,
                dto.getLastName2(),//lastName2,
                dto.getTelephone(),//telephone, 
                dto.getEmail(),//email, 
                dto.getPosition(),//position, 
                dto.getSchedule(),//schedule,
                dto.getSalary()//salary
        );
    }
    
}
