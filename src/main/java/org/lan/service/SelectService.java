package org.lan.service;

import jakarta.annotation.Resource;
import org.lan.mapper.*;
import org.lan.pojo.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component("selectService")
public class SelectService {

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

    public Bus selectBus(String location){
        return busMapper.selectByPrimaryKey(location);
    }

    public List<Bus> selectAllBus(){
        return busMapper.selectAll();
    }

    public Customer selectCustomer(String customerName){
        return customerMapper.selectByPrimaryKey(customerName);
    }

    public List<Customer> selectAllCustomer(){
        return customerMapper.selectAll();
    }

    public Flight selectFlight(String flightNum){
        return flightMapper.selectByPrimaryKey(flightNum);
    }

    public List<Flight> selectAllFlight() {
        return flightMapper.selectAll();
    }

    public Hotel selectHotel(String location) {
        return hotelMapper.selectByPrimaryKey(location);
    }

    public List<Hotel> selectAllHotel() {
        return hotelMapper.selectAll();
    }

    public Reservation selectReservation(Integer reservationKey) {
        return reservationMapper.selectByPrimaryKey(reservationKey);
    }

    public List<Reservation> selectAllReservation(){
        return reservationMapper.selectAll();
    }

    public List<Reservation> selectCustomerBooking(String name) {
        return reservationMapper.selectByCustomerName(name);
    }

    public List<Flight> selectFlightByCustomer(String customerName) {
        List<Flight> flights = new ArrayList<>();
        if (customerName == null) {
            return flights;
        }
        List<Reservation> reservations = reservationMapper.selectOneByCustomerName(customerName,1);
        for (Reservation reservation : reservations) {
            String flight_num = reservation.getReservationThing();
            Flight flight = flightMapper.selectByPrimaryKey(flight_num);
            flights.add(flight);
        }
        return flights;
    }

    public List<Bus> selectBusByCustomer(String customerName) {
        List<Bus> buses = new ArrayList<>();
        if (customerName == null) {
            return buses;
        }
        List<Reservation> reservations = reservationMapper.selectOneByCustomerName(customerName, 3);
        for (Reservation reservation : reservations) {
            String location = reservation.getReservationThing();
            Bus bus = busMapper.selectByPrimaryKey(location);
            buses.add(bus);
        }
        return buses;
    }

    public List<Hotel> selectHotelByCustomerName(String customerName) {
        List<Hotel> hotels = new ArrayList<>();
        if (customerName == null) {
            return hotels;
        }
        List<Reservation> reservations = reservationMapper.selectOneByCustomerName(customerName, 2);
        for (Reservation reservation : reservations) {
            String location = reservation.getReservationThing();
            Hotel hotel = hotelMapper.selectByPrimaryKey(location);
            hotels.add(hotel);
        }
        return hotels;
    }

    public List<Reservation> selectOne(String customerName,Integer reservationType,String reservationThing) throws Exception {
        if (customerName == null) {
            throw new Exception("顾客未选择");
        }
        return reservationMapper.selectOne(customerName,reservationType,reservationThing);
    }
}
