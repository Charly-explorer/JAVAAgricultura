package Model.Production;

import java.util.Date;

/**
 *
 * @author carlo
 */
public class ProductionDTO {
    private final int id;
    private final int crop;
    private final Date date;
    private final int quatity;
    private final String quality;
    private final String destiny;

    public int getId() {
        return id;
    }

    public int getCrop() {
        return crop;
    }

    public Date getDate() {
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

    public ProductionDTO(int id, int crop, Date date, int quatity, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = date;
        this.quatity = quatity;
        this.quality = quality;
        this.destiny = destiny;
    }
}
