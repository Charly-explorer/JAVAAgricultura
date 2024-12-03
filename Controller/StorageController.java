/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Storerooms.Storerooms;
import Model.Storerooms.StoreroomsDAO;
import Model.Storerooms.StoreroomsDTO;
import Model.Storerooms.StoreroomsMapper;
import View.IView;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author emman
 */
public class StorageController {

    private StoreroomsDAO storeroomsDao;
    private final IView view;
    private final StoreroomsMapper mapper;

    public StorageController(IView view) {
        this.view = view;
        this.mapper = new StoreroomsMapper();
        try {
            this.storeroomsDao = new StoreroomsDAO(DataBase.DataBase.getConnetion());
        } catch (SQLException ex) {
            view.showError("Error al conectarse con la base de datos");
        }
    }

    public void create(Storerooms storerooms) {
        if (storerooms == null || !validateStorage(storerooms)) {
            view.showError("Faltan datos por ingresar");
        }
        try {
            if (!validatePK(storerooms.getId())) {
                view.showError("El ID del almacenado ya está ingresado");
                return;
            }
            storeroomsDao.create(mapper.toDto(storerooms));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: " + ex.getMessage());
        }
    }

    public void read(Storerooms storerooms){
        if(storerooms==null || !validateStorage(storerooms)) {
            view.showError("No hay ningun almacenado cargado actualmente");
            return;
        }
        try {
            if (validatePK(storerooms.getId())){
                view.showError("El ID del usuario no está en la Base de Datos");
                return;
            }
            storeroomsDao.read(storerooms.getId());
        }catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public void readAll(){
        try {
            List<StoreroomsDTO> dtoList = storeroomsDao.readAll();
            List<Storerooms> storageList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(storageList);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public void update(Storerooms storage){
        if(storage==null || !validateStorage(storage)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(storage.getId())){
                view.showError("El ID del Usuario no está en la Base de Datos");
                return;
            }
            storeroomsDao.update(mapper.toDto(storage));
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al actualizar los datos: "+ ex.getMessage());
        }
    }   


    public boolean validateStorage(Storerooms storerooms) {
        return storerooms.getIdQuantity() > 0
                && storerooms.getIdProduccion() > 0;
    }

    public boolean validatePK(int id) {
        try {
            return storeroomsDao.validatePk(id);
        } catch (SQLException ex) {
            return false;
        }
    }
}
