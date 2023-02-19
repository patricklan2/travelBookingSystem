package org.lan.pojo;

public class Bus {
    private String location;

    private Integer price;

    private Integer numBus;

    private Integer numSeat;

    private Integer numAvail;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumBus() {
        return numBus;
    }

    public void setNumBus(Integer numBus) {
        this.numBus = numBus;
    }

    public Integer getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(Integer numSeat) {
        this.numSeat = numSeat;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "location='" + location + '\'' +
                ", price=" + price +
                ", numBus=" + numBus +
                ", numSeat=" + numSeat +
                ", numAvail=" + numAvail +
                '}';
    }

    public void book() throws Exception {
        if (numAvail == 0) {
            throw new Exception("seats are full");
        }else{
            numAvail -= 1;
        }
    }

    public Bus(String location, Integer price, Integer numBus, Integer numSeat, Integer numAvail) {
        this.location = location;
        this.price = price;
        this.numBus = numBus;
        this.numSeat = numSeat;
        this.numAvail = numAvail;
    }

    public String[] toList() {
        String[] strings = new String[5];
        strings[0] = location;
        strings[1] = price.toString();
        strings[2] = numBus.toString();
        strings[3] = numSeat.toString();
        strings[4] = numAvail.toString();
        return strings;
    }
}