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
    private int amount;
    private String quality;
    private double percentProduction;
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

    public int getAmount() {
        return amount;
    }

    public double getPercentProduction() {
        return percentProduction;
    }

    public String getQuality() {
        return quality;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.percentProduction = calculatePercentProduction();
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    protected Production(int id, Crop crop, LocalDate date, int amount, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = date;
        this.amount = amount;
        this.quality = quality;
        this.destiny = destiny;
    }
    
    public Production(int id, Crop crop, int amount, String quality, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = LocalDate.now();
        this.amount = amount;
        this.percentProduction = calculatePercentProduction();
        this.quality = quality;
        this.destiny = destiny;
    } 
    
    protected double calculatePercentProduction(){
        return this.percentProduction = (amount/300)*100;
    }
}
