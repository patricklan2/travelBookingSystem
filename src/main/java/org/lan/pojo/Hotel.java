package org.lan.pojo;

public class Hotel {
    private String location;

    private Integer price;

    private Integer numRoom;

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

    public Integer getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(Integer numRoom) {
        this.numRoom = numRoom;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "location='" + location + '\'' +
                ", price=" + price +
                ", numRoom=" + numRoom +
                ", numAvail=" + numAvail +
                '}';
    }

    public void book() throws Exception {
        if (numAvail == 0) {
            throw new Exception("rooms are full");
        }else{
            numAvail -= 1;
        }
    }

    public Hotel(String location, Integer price, Integer numRoom, Integer numAvail) {
        this.location = location;
        this.price = price;
        this.numRoom = numRoom;
        this.numAvail = numAvail;
    }

    public String[] toList() {
        String[] strings = new String[4];
        strings[0] = location;
        strings[1] = price.toString();
        strings[2] = numRoom.toString();
        strings[3] = numAvail.toString();
        return strings;
    }
}