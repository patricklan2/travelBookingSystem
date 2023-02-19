package org.lan.mapper;

import java.util.List;
import org.lan.pojo.Hotel;

public interface HotelMapper {
    int deleteByPrimaryKey(String location);

    int insert(Hotel row);

    Hotel selectByPrimaryKey(String location);

    List<Hotel> selectAll();

    int updateByPrimaryKey(Hotel row);
}