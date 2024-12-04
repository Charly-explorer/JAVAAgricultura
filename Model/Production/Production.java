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
    private int amount2;
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

    public int getAmount2() {
        return amount2;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.percentProduction = calculatePercentProduction();
    }

    public void setQuality(int amount2) {
        this.amount2 = amount2;
        this.percentProduction = calculatePercentProduction();
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    protected Production(int id, Crop crop, LocalDate date, int amount, int amount2, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = date;
        this.amount = amount;
        this.amount2 = amount2;
        this.percentProduction = calculatePercentProduction();
        this.destiny = destiny;
    }
    
    public Production(int id, Crop crop, int amount, int amount2, String destiny) {
        this.id = id;
        this.crop = crop;
        this.date = LocalDate.now();
        this.amount = amount;
        this.amount2 = amount2;
        this.percentProduction = calculatePercentProduction();
        this.destiny = destiny;
    } 
    
    protected double calculatePercentProduction(){
        return this.percentProduction = (amount/100)*amount2;
    }
}
