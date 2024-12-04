/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Users.Users;
import Model.Users.UsersDTO;
import Model.Users.UsersDao;
import Model.Users.UsersMapper;
import View.IView;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author emman
 */
public class UsersController {

    private UsersDao userDao;
    private final IView view;
    private final UsersMapper mapper;

    public UsersController(IView view) {
        this.view = view;
        this.mapper = new UsersMapper();
        try {
            this.userDao = new UsersDao(DataBase.DataBase.getConnetion());
        } catch (SQLException ex) {
            view.showError("Error al conectarse con la base de datos");
        }
    }

    public void create(Users user) {
        if (user == null || !validateUser(user)) {
            view.showError("Faltan datos por ingresar");
        }
        try {
            if (!validatePK(user.getId())) {
                view.showError("El ID del usuario ya está ingresado");
                return;
            }
            userDao.create(mapper.toDto(user));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: " + ex.getMessage());
        }
    }

    public void read(Users user){
        if(user==null || !validateUser(user)) {
            view.showError("No hay ningun usuario cargado actualmente");
            return;
        }
        try {
            if (validatePK(user.getId())){
                view.showError("El ID del usuario no está en la Base de Datos");
                return;
            }
            userDao.read(user.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public void readAll(){
        try {
            List<UsersDTO> dtoList = userDao.readAll();
            List<Users> customerList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(customerList);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public void update(Users user){
        if(user==null || !validateUser(user)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(user.getId())){
                view.showError("El ID del Usuario no está en la Base de Datos");
                return;
            }
            userDao.update(mapper.toDto(user));
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al actualizar los datos: "+ ex.getMessage());
        }
    }   
    
    public void delete(Users user){
        if(user==null || !validateUser(user)) {
            view.showError("No hay ningun usuario cargado actualmente");
            return;
        }
        try {
            if (validatePK(user.getId())){
                view.showError("El ID del usuario no está en la Base de Datos");
                return;
            }
            userDao.delete(user.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }

    public boolean validateUser(Users user) {
        return !user.getName().trim().isEmpty()
                && !user.getPassword().trim().isEmpty()
                && user.getId() > 0;
    }

    public boolean validatePK(int id) {
        try {
            return userDao.validatePk(id);
        } catch (SQLException ex) {
            return false;
        }
    }
}
