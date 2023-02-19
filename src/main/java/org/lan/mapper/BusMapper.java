package org.lan.mapper;

import java.util.List;
import org.lan.pojo.Bus;

public interface BusMapper {
    int deleteByPrimaryKey(String location);

    int insert(Bus row);

    Bus selectByPrimaryKey(String location);

    List<Bus> selectAll();

    int updateByPrimaryKey(Bus row);
}