/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Crops;

import Model.State.CropState;
import java.util.Date;

/**
 *
 * @author Johel M
 */
public class CropDTO {
    private final int id;
    private final String name;
    private final String type;
    private final String area;
    private final CropState state;
    private final Date sowingDate;
    private final Date harvestDate;

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

    public Date getSowingDate() {
        return sowingDate;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public CropDTO(int id, String name, String type, String area, CropState state, Date sowingDate, Date harvestDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.state = state;
        this.sowingDate = sowingDate;
        this.harvestDate = harvestDate;
    }
    
    
}
