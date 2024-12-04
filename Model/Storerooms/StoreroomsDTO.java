package Model.Storerooms;

import java.sql.Date;

/**
 *
 * @author carlo
 */
public class StoreroomsDTO {

    private final int id;
    private final int idProduccion;
    private final double idQuantity;
    private final Date entryDate;
    private final Date departureDate;
    private final boolean alert;

    public int getId() {
        return id;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public double getIdQuantity() {
        return idQuantity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public boolean isAlert() {
        return alert;
    }

    public StoreroomsDTO(int id,int idProduccion, double idQuantity, Date entryDate, Date departureDate, boolean alert) {
        this.id = id;
        this.idProduccion = idProduccion;
        this.idQuantity = idQuantity;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.alert = alert;
    }

}
