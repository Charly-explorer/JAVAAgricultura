/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Production.Production;
import Model.Production.ProductionDTO;
import Model.Production.ProductionDao;
import Model.Production.ProductionMapper;
import View.IView;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author Johel M
 */
public class ProductionController {

    private ProductionDao productionDao;
    private final IView view;
    private final ProductionMapper mapper;

    public ProductionController(IView view) {
        this.view = view;
        this.mapper = new ProductionMapper();
        try {
            this.productionDao = new ProductionDao(DataBase.DataBase.getConnetion());
        } catch (SQLException ex) {
            view.showError("Error al conectar con la Base de Datos");
        }
    }

    public void create(Production production){
        if(production == null || !validateCrop(production))
            view.showError("Faltan datos por ingresar");
        try {
            productionDao.create(mapper.toDto(production));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: "+ ex.getMessage());
        }
    }
    
    public void read(Production production){
        if(production==null || !validateCrop(production)) {
            view.showError("No hay ningun producción cargada actualmente");
            return;
        }
        try {
            if (production.getId() > 0){
                view.showError("El ID no puede ser menor que 1");
                return;
            }
            productionDao.read(production.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public void readAll(){
        try {
            List<ProductionDTO> dtoList = productionDao.readAll();
            List<Production> productions = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(productions);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public boolean validateCrop(Production production){
        return production.getId() > 0 && 
               production.getCrop() != null && 
               production.getAmount() > 0 &&
               !production.getQuality().trim().isEmpty() &&
               !production.getDestiny().trim().isEmpty();
    }
    
}
