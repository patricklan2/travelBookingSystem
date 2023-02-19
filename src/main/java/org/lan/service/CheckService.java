package org.lan.service;

import jakarta.annotation.Resource;
import org.lan.mapper.FlightMapper;
import org.lan.mapper.ReservationMapper;
import org.lan.pojo.Flight;
import org.lan.pojo.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component("checkService")
public class CheckService {
    @Resource(name = "reservationMapper")
    ReservationMapper reservationMapper;

    @Resource(name = "flightMapper")
    FlightMapper flightMapper;

    public List<List<String>> getBookByCustomerName(String customerName) {
        HashMap<String,String[]> hash = new HashMap<>();
        List<Reservation> reservations = reservationMapper.selectByCustomerName(customerName);
        for (Reservation reservation : reservations) {
            Integer reservationType = reservation.getReservationType();
            String location;
            if (reservationType == 1) {
                Flight flight = flightMapper.selectByPrimaryKey(reservation.getReservationThing());
                location = flight.getArriveCity();
            }else {
                location = reservation.getReservationThing();
            }
            if (!hash.containsKey(location)){
                hash.put(location, new String[]{"缺", "缺", "缺"});
            }
            hash.get(location)[reservationType - 1] = "已预订";
        }
        List<List<String>> result = new ArrayList<>();
        for (String location : hash.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(location);
            temp.addAll(Arrays.asList(hash.get(location)));
            result.add(temp);
        }
        return result;
    }

}
