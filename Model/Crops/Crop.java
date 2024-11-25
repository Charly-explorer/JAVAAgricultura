/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Crops;

import Model.State.CropState;
import Model.State.SownCropState;
import java.time.LocalDate;

/**
 *
 * @author Johel M
 */
public class Crop {
    private int id;
    private String name;
    private String type;
    private String area;
    private CropState state;
    private LocalDate sowingDate;
    private LocalDate harvestDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getArea() {
        return area;
    }

    public CropState getState() {
        return state;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setState(CropState state) {
        this.state = state;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    protected Crop(int id, String name, String type, String area, CropState state, LocalDate sowingDate, LocalDate harvestDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.state = state;
        this.sowingDate = sowingDate;
        this.harvestDate = harvestDate;
    }
    
    public Crop(int id, String name, String type, String area, LocalDate sowingDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.state = new SownCropState(this);
        this.sowingDate = sowingDate;
        this.harvestDate = null;
    }
    
}
