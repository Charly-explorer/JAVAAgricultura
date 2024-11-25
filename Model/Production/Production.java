package Model.Production;

import Model.Crops.Crop;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class Production {
    private int id;
    private Crop crop;
    private LocalDate date;
    private int quatity;
    private String quality;
    private String destiny;

    public int getId() {
        return id;
    }

    public Crop getCrop() {
        return crop;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuatity() {
        return quatity;
    }

    public String getQuality() {
        return quality;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    protected Production(int id, Crop crop, LocalDate date, int quatity, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = date;
        this.quatity = quatity;
        this.quality = quality;
        this.destiny = destiny;
    }
    
    public Production(int id, Crop crop, int quatity, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = LocalDate.now();
        this.quatity = quatity;
        this.quality = quality;
        this.destiny = destiny;
    }
}
