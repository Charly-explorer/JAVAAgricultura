/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void create(Production production) {
        if (production == null || !validateCrop(production)) {
            view.showError("Faltan datos por ingresar");
        }
        try {
            productionDao.create(mapper.toDto(production));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: " + ex.getMessage());
        }
    }

    public void read(Production production) {
        if (production == null || !validateCrop(production)) {
            view.showError("No hay ningun producción cargada actualmente");
            return;
        }
        try {
            if (production.getId() > 0) {
                view.showError("El ID no puede ser menor que 1");
                return;
            }
            productionDao.read(production.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: " + ex.getMessage());
        }
    }

    public void readAll() {
        try {
            List<ProductionDTO> dtoList = productionDao.readAll();
            List<Production> productions = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(productions);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: " + ex.getMessage());
        }
    }

    public List<Production> readAllXML() {
        try {
            List<ProductionDTO> dtoList = productionDao.readAll();
            List<Production> productions = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            return productions;
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: " + ex.getMessage());
        }
        return null;
    }

    public void generarReporteXML(List<Production> producciones, String outputPath) {
        try {
            // Crear un StringBuilder para construir el contenido del archivo XML
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlContent.append("<Producciones>\n");

            // Iterar sobre las producciones y agregarlas al XML
            for (Production produccion : producciones) {
                xmlContent.append("    <Produccion>\n");
                xmlContent.append("        <ID>").append(produccion.getId()).append("</ID>\n");
                xmlContent.append("        <Cultivo>").append(produccion.getCrop().getName()).append("</Cultivo>\n");
                xmlContent.append("        <Fecha>").append(produccion.getDate()).append("</Fecha>\n");
                xmlContent.append("        <Cantidad>").append(produccion.getAmount()).append("</Cantidad>\n");
                xmlContent.append("        <CantidadProduccion>").append(produccion.getAmount2()).append("</CantidadProduccion>\n");
                xmlContent.append("        <PorcentajeProduccion>").append(produccion.getPercentProduction()).append("</PorcentajeProduccion>\n");
                xmlContent.append("        <Destino>").append(produccion.getDestiny()).append("</Destino>\n");
                xmlContent.append("    </Produccion>\n");
            }

            xmlContent.append("</Producciones>");

            // Escribir el contenido en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                writer.write(xmlContent.toString());
            }

            System.out.println("Reporte XML generado correctamente en: " + outputPath);

        } catch (IOException e) {
            System.err.println("Error al generar el reporte XML: " + e.getMessage());
        }
    }

    /**
     * Agrega un elemento al nodo principal del documento.
     *
     * @param document Documento XML.
     * @param parent Nodo padre donde se agregará el nuevo elemento.
     * @param name Nombre del elemento.
     * @param value Valor del elemento.
     */
    private void addElement(Document document, Element parent, String name, String value) {
        Element element = document.createElement(name);
        element.appendChild(document.createTextNode(value));
        parent.appendChild(element);
    }

    public boolean validateCrop(Production production) {
        return production.getId() > 0
                && production.getCrop() != null
                && production.getAmount() > 0
                && production.getAmount2() > 0
                && !production.getDestiny().trim().isEmpty();
    }

}
