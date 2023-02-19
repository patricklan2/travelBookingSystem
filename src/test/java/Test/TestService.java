//package Test;
//
//import org.junit.Test;
//import org.lan.pojo.Bus;
//import org.lan.pojo.Customer;
//import org.lan.pojo.Flight;
//import org.lan.pojo.Reservation;
//import org.lan.service.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestService {
//
//    @Test
//    public void Test01() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        SelectService selectService = applicationContext.getBean("selectService", SelectService.class);
//        Bus bus = selectService.selectBus("钟楼");
//        System.out.println(bus);
//    }
//
//    @Test
//    public void Test02(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BookService bookService = applicationContext.getBean("bookService", BookService.class);
//        SelectService selectService = applicationContext.getBean("selectService", SelectService.class);
//
//        List<Bus> buses = selectService.selectAllBus();
//        Bus bus = buses.get(0);
//        List<Customer> customers = selectService.selectAllCustomer();
//        Customer customer = customers.get(0);
//
//        System.out.println(bus);
//        System.out.println(customer);
//
//        final int i = bookService.bookBus(bus, customer);
//        System.out.println(i);
//    }
//
//    @Test
//    public void Test03() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BookService bookService = applicationContext.getBean("bookService", BookService.class);
//        int i = bookService.cancelByKey("Tom钟楼");
//
//        System.out.println(i);
//    }
//
//    @Test
//    public void Test04() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        SelectService selectService = applicationContext.getBean("selectService", SelectService.class);
//        List<Reservation> reservations = selectService.selectCustomerBooking("Tom");
//
//        System.out.println(reservations);
//    }
//
//    @Test
//    public void Test05() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BookService bookService1 = applicationContext.getBean("bookService", BookService.class);
//        final SelectService selectService = applicationContext.getBean("selectService", SelectService.class);
//        final List<Flight> flights = selectService.selectAllFlight();
//        final Customer tom = selectService.selectCustomer("Tom");
//        bookService1.bookFlight(flights.get(2),tom);
//
//    }
//
//    @Test
//    public void Tese06() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BookService bookService1 = applicationContext.getBean("bookService", BookService.class);
//        final SelectService selectService = applicationContext.getBean("selectService", SelectService.class);
//        final CheckService checkService = applicationContext.getBean("checkService", CheckService.class);
//        final List<String> travelMap = checkService.getTravelMap("Tom");
//
//        System.out.println(travelMap);
//
//        System.out.println(checkService.getTravelFull("Tom"));
//    }
//}
