package Test;

import org.junit.Test;
import org.lan.mapper.BusMapper;
import org.lan.mapper.HotelMapper;
import org.lan.mapper.ReservationMapper;
import org.lan.pojo.Bus;
import org.lan.pojo.Reservation;
import org.lan.service.SelectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMapper {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        final HotelMapper hotelMapper = applicationContext.getBean("hotelMapper", HotelMapper.class);
        ReservationMapper reservationMapper = applicationContext.getBean("reservationMapper", ReservationMapper.class);

        final List<Reservation> reservations = reservationMapper.selectOneByCustomerName("Jack", 2);
        final List<Reservation> jack = reservationMapper.selectOne("jack", 1, "001");
        System.out.println(jack);

//        Bus bus = new Bus("C塔",20,30,20,20);
//        busMapper.insert(bus);

//        System.out.println(bus);
//        hotelMapper.deleteByPrimaryKey("B");

    }
}
