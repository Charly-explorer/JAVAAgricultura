package Model.Storerooms;

import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class Storerooms {

    private int id;
    private int idProduccion;
    private double idQuantity;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private boolean alert;

    public int getId() {
        return id;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public double getIdQuantity() {
        return idQuantity;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setIdQuantity(double idQuantity) {
        this.idQuantity = idQuantity;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Storerooms(int idProduccion, double idQuantity, LocalDate entryDate, LocalDate departureDate, boolean alert) {
        this.idProduccion = idProduccion;
        this.idQuantity = idQuantity;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.alert = alert;
    }

    public Storerooms(int id, int idProduccion, double idQuantity) {
        this.id = id;
        this.idProduccion = idProduccion;
        this.idQuantity = idQuantity;
        this.entryDate = LocalDate.now();
        this.departureDate = null;
        //this.alert = alert;
    }

}
