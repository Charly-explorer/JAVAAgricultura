/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Crops.Crop;
import Model.Crops.CropDTO;
import Model.Crops.CropDao;
import Model.Crops.CropMapper;
import Model.State.CropState;
import Model.State.HarvestedCropState;
import Model.State.LostCropState;
import Model.State.RipenningCropState;
import Model.State.SownCropState;
import View.IView;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author carlo
 */
public class CropController {
    private CropDao cropDao;
    private final IView view;
    private final CropMapper mapper;

    public CropController(IView view) {
        this.view = view;
        this.mapper = new CropMapper();
        try {
            this.cropDao = new CropDao(DataBase.DataBase.getConnetion());
        } catch (SQLException ex) {
            view.showError("Error al conectarse con la base de datos");
        }
    }
    public void create(Crop crop){
        if(crop == null || !validateCrop(crop))
            view.showError("Faltan datos por ingresar");
        try {
            if (!validatePK(crop.getId())){
                view.showError("El ID del cultivo ya está ingresado");
                return;
            }
            cropDao.create(mapper.toDto(crop));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: "+ ex.getMessage());
        }
    }
    
    public void read(Crop crop){
        if(crop==null || !validateCrop(crop)) {
            view.showError("No hay ningun cultivo cargado actualmente");
            return;
        }
        try {
            if (validatePK(crop.getId())){
                view.showError("El ID del cultivo no está en la Base de Datos");
                return;
            }
            cropDao.read(crop.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public void readAll(){
        try {
            List<CropDTO> dtoList = cropDao.readAll();
            List<Crop> customerList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(customerList);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public void delete(Crop crop){
        if(crop==null || !validateCrop(crop)) {
            view.showError("No hay ningun cultivo cargado actualmente");
            return;
        }
        try {
            if (validatePK(crop.getId())){
                view.showError("El ID del cultivo no está en la Base de Datos");
                return;
            }
            cropDao.delete(crop.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public void update(Crop crop){
        if(crop==null || !validateCrop(crop)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(crop.getId())){
                view.showError("El ID del cultivo no está en la Base de Datos");
                return;
            }
            cropDao.update(mapper.toDto(crop));
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al actualizar los datos: "+ ex.getMessage());
        }
    }
    
    public boolean validateCrop(Crop crop){
        return crop.getId() > 0 && 
                !crop.getName().trim().isEmpty() && 
                !crop.getArea().trim().isEmpty() &&
                !crop.getType().trim().isEmpty();
    }
    
    public boolean validatePK(int id) {
        try {
            return cropDao.validatePk(id);
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public String convertStateToString(CropState state) {
        Map<Class<? extends CropState>, String> states = Map.of(
                HarvestedCropState.class, "Cosechado",
                LostCropState.class, "Perdida",
                RipenningCropState.class, "Maduración",
                SownCropState.class, "Siembra");
        return states.getOrDefault(state.getClass(), "Siembra");
    }
}
