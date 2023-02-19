package org.lan.pojo;

public class Flight {
    private String flightNum;

    private Integer price;

    private Integer numSeats;

    private Integer numAvail;

    private String fromCity;

    private String arriveCity;

    private String time;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum == null ? null : flightNum.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }

    public Integer getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(Integer numAvail) {
        this.numAvail = numAvail;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity == null ? null : fromCity.trim();
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity == null ? null : arriveCity.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum='" + flightNum + '\'' +
                ", price=" + price +
                ", numSeats=" + numSeats +
                ", numAvail=" + numAvail +
                ", fromCity='" + fromCity + '\'' +
                ", arriveCity='" + arriveCity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public void book() throws Exception {
        if (numAvail == 0) {
            throw new Exception("seats are full");
        }else{
            numAvail -= 1;
        }
    }

    public Flight(String flightNum, Integer price, Integer numSeats, Integer numAvail, String fromCity, String arriveCity, String time) {
        this.flightNum = flightNum;
        this.price = price;
        this.numSeats = numSeats;
        this.numAvail = numAvail;
        this.fromCity = fromCity;
        this.arriveCity = arriveCity;
        this.time = time;
    }

    public String[] toList() {
        String[] strings = new String[7];
        strings[0] = flightNum;
        strings[1] = price.toString();
        strings[2] = numSeats.toString();
        strings[3] = numAvail.toString();
        strings[4] = fromCity;
        strings[5] = arriveCity;
        strings[6] = time;
        return strings;
    }
}