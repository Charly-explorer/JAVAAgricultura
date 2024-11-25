package Model.Storerooms;

import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class StoreromsDTO {

    private final int idProduccion;
    private final double idQuantity;
    private final LocalDate entryDate;
    private final LocalDate departureDate;
    private final boolean alert;

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

    public StoreromsDTO(int idProduccion, double idQuantity, LocalDate entryDate, LocalDate departureDate, boolean alert) {
        this.idProduccion = idProduccion;
        this.idQuantity = idQuantity;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.alert = alert;
    }
    

}
