package org.lan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lan.pojo.Reservation;

public interface ReservationMapper {
    int deleteByPrimaryKey(Integer reservationKey);

    int insert(Reservation row);

    Reservation selectByPrimaryKey(Integer reservationKey);

    List<Reservation> selectAll();

    int updateByPrimaryKey(Reservation row);

    List<Reservation> selectByCustomerName(String customerName);

    List<Reservation> selectOneByCustomerName(@Param("customerName") String customerName, @Param("reservationType") Integer reservationType);

    List<Reservation> selectOne(@Param("customerName") String customerName, @Param("reservationType") Integer reservationType, @Param("reservationThing") String reservationThing);
}