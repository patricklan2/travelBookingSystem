package org.lan.service;

import jakarta.annotation.Resource;
import org.lan.mapper.*;
import org.lan.pojo.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("bookService")
public class BookService{

    @Resource(name = "reservationMapper")
    ReservationMapper reservationMapper;

    @Resource(name = "busMapper")
    BusMapper busMapper;

    @Resource(name = "flightMapper")
    FlightMapper flightMapper;

    @Resource(name = "hotelMapper")
    HotelMapper hotelMapper;

    @Resource(name = "customerMapper")
    CustomerMapper customerMapper;

    public int cancelByKey(Reservation reservation) throws Exception {
        int count = 0;
        if (reservation == null) {
            throw new Exception("Object is not found");
        }
        Integer reservationType = reservation.getReservationType();
        String reservationThing = reservation.getReservationThing();
        switch (reservationType) {
            case 1 -> {
                Flight flight = flightMapper.selectByPrimaryKey(reservationThing);
                flight.setNumAvail(flight.getNumAvail() + 1);
                count += flightMapper.updateByPrimaryKey(flight);
            }
            case 2 -> {
                Hotel hotel = hotelMapper.selectByPrimaryKey(reservationThing);
                hotel.setNumAvail(hotel.getNumAvail() + 1);
                count += hotelMapper.updateByPrimaryKey(hotel);
            }
            case 3 -> {
                Bus bus = busMapper.selectByPrimaryKey(reservationThing);
                bus.setNumAvail(bus.getNumAvail() + 1);
                count += busMapper.updateByPrimaryKey(bus);
            }
        }
        count += reservationMapper.deleteByPrimaryKey(reservation.getReservationKey());
        return count;
    }

    private int bookAdapt(String customerName,String thing,int type) throws Exception {
        int count = 0;
        if (customerName == null) {
            throw new Exception("未选择顾客");
        }
        Customer customer = customerMapper.selectByPrimaryKey(customerName);
        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setReservationThing(thing);
        reservation.setReservationType(type);
        switch (type) {
            case 1 ->{
                Flight flight = flightMapper.selectByPrimaryKey(thing);
                if (flight == null) {
                    throw new Exception("Object is not found");
                }else{
                    flight.book();
                    count += flightMapper.updateByPrimaryKey(flight);
                }
            }
            case 2 ->{
                Hotel hotel = hotelMapper.selectByPrimaryKey(thing);
                if (hotel == null) {
                    throw new Exception("Object is not found");
                }else{
                    hotel.book();
                    count += hotelMapper.updateByPrimaryKey(hotel);
                }
            }
            case 3 ->{
                Bus bus = busMapper.selectByPrimaryKey(thing);
                if (bus == null) {
                    throw new Exception("Object is not found");
                }else{
                    bus.book();
                    count += busMapper.updateByPrimaryKey(bus);
                }
            }
        }
        count += reservationMapper.insert(reservation);
        return count;
    }

    public int bookFlight( String customerName,String flightNum) throws Exception {
        return bookAdapt(customerName,flightNum,1);
    }

    public int bookHotel(String customerName,String location) throws Exception {
        return bookAdapt(customerName,location,2);
    }

    public int bookBus(String customerName,String location) throws Exception {
       return bookAdapt(customerName,location,3);
    }
}
