package Model.Production;

import java.sql.Date;

/**
 *
 * @author carlo
 */
public class ProductionDTO {
    private final int id;
    private final int crop;
    private final Date date;
    private final int amount;
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

    public int getAmount() {
        return amount;
    }

    public String getQuality() {
        return quality;
    }

    public String getDestiny() {
        return destiny;
    }

    public ProductionDTO(int id, int crop, Date date, int amount, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = date;
        this.amount = amount;
        this.quality = quality;
        this.destiny = destiny;
    }
}
