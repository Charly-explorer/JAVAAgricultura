/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Users;

import Model.Mapper.Mapper;

/**
 *
 * @author carlo
 */
public class UsersMapper implements Mapper<Users,UsersDTO> {

    @Override
    public UsersDTO toDto(Users ent) {
        return new UsersDTO(
                ent.getId(),
                ent.getName(),
                ""
        );
    }

    @Override
    public Users toEnt(UsersDTO dto) {
        return new Users(
                dto.getId(), 
                dto.getName(), 
                ""
        );
    }
    
}
