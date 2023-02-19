package org.lan.pojo;

public class Reservation {
    private Integer reservationKey;

    private String customerName;

    private Integer reservationType;

    private String reservationThing;

    public Integer getReservationKey() {
        return reservationKey;
    }

    public void setReservationKey(Integer reservationKey) {
        this.reservationKey = reservationKey;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getReservationType() {
        return reservationType;
    }

    public void setReservationType(Integer reservationType) {
        this.reservationType = reservationType;
    }

    public String getReservationThing() {
        return reservationThing;
    }

    public void setReservationThing(String reservationThing) {
        this.reservationThing = reservationThing == null ? null : reservationThing.trim();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationKey=" + reservationKey +
                ", customerName='" + customerName + '\'' +
                ", reservationType=" + reservationType +
                ", reservationThing='" + reservationThing + '\'' +
                '}';
    }
}