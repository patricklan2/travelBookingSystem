package org.lan.service;

import jakarta.annotation.Resource;
import org.lan.mapper.*;
import org.lan.pojo.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component("insertService")
public class InsertService {
    @Resource(name = "busMapper")
    BusMapper busMapper;

    @Resource(name = "flightMapper")
    FlightMapper flightMapper;

    @Resource(name = "hotelMapper")
    HotelMapper hotelMapper;

    @Resource(name = "customerMapper")
    CustomerMapper customerMapper;

    @Resource(name = "reservationMapper")
    ReservationMapper reservationMapper;

    public int insertBus(String location, Integer price, Integer numBus, Integer numSeat) {
        Bus bus = new Bus(location, price, numBus, numSeat, numSeat);
        return busMapper.insert(bus);
    }

    public int insertFlight(String flightNum, Integer price, Integer numSeats, String fromCity, String arriveCity, String time) {
        Flight flight = new Flight(flightNum, price, numSeats, numSeats, fromCity, arriveCity, time);
        return flightMapper.insert(flight);
    }

    public int insertHotel(String location, Integer price, Integer numRoom) {
        Hotel hotel = new Hotel(location, price, numRoom, numRoom);
        return hotelMapper.insert(hotel);
    }

    public int insertCustomer(String customerName, String customerId) {
        Customer customer = new Customer(customerName, customerId);
        return customerMapper.insert(customer);
    }

    public void deleteBus(String location) throws Exception {
        Bus bus = busMapper.selectByPrimaryKey(location);
        if(bus.getNumAvail() == bus.getNumSeat()) {
            busMapper.deleteByPrimaryKey(location);
        }else{
            throw new Exception("无法删除");
        }
    }

    public void deleteFlight(String flightNum) throws Exception {
        Flight flight = flightMapper.selectByPrimaryKey(flightNum);
        if(flight.getNumAvail() == flight.getNumSeats()){
            flightMapper.deleteByPrimaryKey(flightNum);
        }else{
            throw new Exception("无法删除");
        }

    }

    public void deleteCustomer(String customerName) throws Exception {
        List<Reservation> reservations = reservationMapper.selectByCustomerName(customerName);
        if (reservations.size() == 0) {
            customerMapper.deleteByPrimaryKey(customerName);
        }else{
            throw new Exception("无法删除");
        }
    }

    public void deleteHotel(String location) throws Exception {
        final Hotel hotel = hotelMapper.selectByPrimaryKey(location);
        if(hotel.getNumAvail() == hotel.getNumRoom()){
            hotelMapper.deleteByPrimaryKey(location);
        }else{
            throw new Exception("无法删除");
        }
    }
}
