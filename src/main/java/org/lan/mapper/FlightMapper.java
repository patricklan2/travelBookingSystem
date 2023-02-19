package org.lan.mapper;

import java.util.List;
import org.lan.pojo.Flight;

public interface FlightMapper {
    int deleteByPrimaryKey(String flightNum);

    int insert(Flight row);

    Flight selectByPrimaryKey(String flightNum);

    List<Flight> selectAll();

    int updateByPrimaryKey(Flight row);
}