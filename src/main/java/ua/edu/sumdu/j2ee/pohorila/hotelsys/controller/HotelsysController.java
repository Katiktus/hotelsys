package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Order;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.HotelsysService;

import java.util.ArrayList;
import java.util.Collections;


@Controller
public class HotelsysController {

    @Autowired
    public HotelsysService hotelsysService;
    Logger logger = LoggerFactory.getLogger(HotelsysController.class);

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>Hello World, this is Tested Spring MVC</h3></div><br><br>";
        logger.info("welcome controller");
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(){
        ModelAndView model = new ModelAndView("deleteUser");
        ArrayList<User> objects = hotelsysService.getAllUsers().getArr();
        model.addObject("usersObj", objects);
        logger.info("deleteUser controller, objects: "+objects.toString());
        return model;
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("userId") int userId){
        hotelsysService.removeUser(userId);
        logger.info("deleteUser controller id:" + userId);
        return "redirect:/users.html";
    }

    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteCustomer(){
        ModelAndView model = new ModelAndView("deleteCustomer");
        ArrayList<Customer> objects = hotelsysService.getAllCustomer().getArr();
        model.addObject("customersObj", objects);
        logger.info("deleteCustomer controller objects:"+objects.toString());
        return model;
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@ModelAttribute("customerId") int customerId){
        hotelsysService.removeCustomer(customerId);
        logger.info("deleteCustomer controller id:" + customerId);
        return "redirect:/customers.html";
    }

    @RequestMapping("/deleteRoom")
    public ModelAndView deleteRoom(){
        ModelAndView model = new ModelAndView("deleteRoom");
        ArrayList<Room> objects = hotelsysService.getAllRooms().getArr();
        model.addObject("roomsObj", objects);
        logger.info("deleteRoom controller objects:"+objects.toString());
        return model;
    }

    @PostMapping("/deleteRoom")
    public String deleteRoom(@ModelAttribute("roomNumber") int roomNumber){
        hotelsysService.removeRoom(roomNumber);
        logger.info("roomNumber controller id:" + roomNumber);
        return "redirect:/rooms.html";
    }


    @GetMapping("/addUser")
    public ModelAndView addUserPage(){
        ModelAndView model = new ModelAndView("addUser");
        logger.info("addUser controller");
        return model;
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user")User user){
        hotelsysService.addUser(user.getName(), user.getManagerId(), user.getRoleId(), user.getPhoneNum(), user.getHotelID());
        logger.info("addUser controller, user:"+ user.toString());
        return "redirect:/users.html";
    }

    @GetMapping("/addCustomer")
    public ModelAndView addCustomerPage(){
        ModelAndView model = new ModelAndView("addCustomer");
        logger.info("addCustomer controller");
        return model;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        hotelsysService.addCustomer(customer.getName(), customer.getPhoneNumber());
        logger.info("addCustomer controller "+customer.toString());
        return "redirect:/customers.html";
    }

    @GetMapping("/addRoom")
    public ModelAndView addRoomPage(){
        ModelAndView model = new ModelAndView("addRoom");
        logger.info("addRoom controller");
        return model;
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute("room") Room room){
        hotelsysService.addRoom(room.getRoomType(), room.getCapacity(), room.getPrice(), room.getHotelID());
        logger.info("addRoom controller, object:" +room.toString());
        return "redirect:/rooms.html";
    }

    @GetMapping("/updateRoomPrice")
    public ModelAndView updateRoomPricePage(){
        ModelAndView model = new ModelAndView("updateRoomPrice");
        logger.info("updateRoomPrice controller");
        return model;
    }

    @PostMapping("/updateRoomPrice")
    public String updateRoomPrice(@ModelAttribute("price") int price, @ModelAttribute("roomNumber") int id){
        hotelsysService.updateRoomPrice(id, price);
        logger.info("updateRoomPrice controller, id:" +id+ " price:"+price);
        return "redirect:/rooms.html";
    }

    @GetMapping("/updateCustomerPhone")
    public ModelAndView updateCustomerPhonePage(){
        ModelAndView model = new ModelAndView("updateCustomerPhone");
        logger.info("updateCustomerPhone controller");
        return model;
    }

    @PostMapping("/updateCustomerPhone")
    public String updateCustomerPhone(@ModelAttribute("phone") String phone, @ModelAttribute("id") int id){
        hotelsysService.updateCustomerPhone(id, phone);
        logger.info("updateCustomerPhone controller, id:" +id+ " phone:"+phone);
        return "redirect:/customers.html";
    }

    @GetMapping("/updateUserMgr")
    public ModelAndView updateUserMgrPage(){
        ModelAndView model = new ModelAndView("updateUserMgr");
        logger.info("updateUserMgr controller");
        return model;
    }

    @PostMapping("/updateUserMgr")
    public String updateUserMgr(@ModelAttribute("userId") int userId, @ModelAttribute("managerId") int mgrId){
        hotelsysService.updateUserMgr(userId, mgrId);
        logger.info("updateUserMgr controller, id:" +userId+ " mgr:"+mgrId);
        return "redirect:/users.html";
    }

    @GetMapping("/updateUserPhone")
    public ModelAndView updateUserPhonePage(){
        ModelAndView model = new ModelAndView("updateUserPhone");
        logger.info("updateUserPhone controller");
        return model;
    }

    @PostMapping("/updateUserPhone")
    public String updateUserPhone(@ModelAttribute("userId") int userId, @ModelAttribute("phone") String phone){
        hotelsysService.updateUserPhone(userId, phone);
        logger.info("updateUserPhone controller, id:" +userId+ " mgr:"+phone);
        return "redirect:/users.html";
    }

        @GetMapping("/updateUserRole")
    public ModelAndView updateUserRolePage(){
        ModelAndView model = new ModelAndView("updateUserRole");
        logger.info("updateUserRole controller");
        return model;
    }

    @PostMapping("/updateUserRole")
    public String updateUserRole(@ModelAttribute("userId") int userId, @ModelAttribute("roleId") int roleId){
        hotelsysService.updateUserRole(userId, roleId);
        logger.info("updateUserRole controller, id:" +userId+ " mgr:"+roleId);
        return "redirect:/users.html";
    }

    @GetMapping("/addOrder")
    public ModelAndView addOrderPage(){
        ModelAndView model = new ModelAndView("addOrder");
        logger.info("addOrder controller");
        return model;
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){
        hotelsysService.addOrder(order.getCustomerId(), order.getRoomNumber());
        logger.info("addOrder controller, order" +order);
        return "redirect:/orders.html";
    }

    @RequestMapping("/deleteOrder")
    public ModelAndView deleteOrder(){
        ModelAndView model = new ModelAndView("deleteOrder");
        ArrayList<Order> objects = hotelsysService.getAllOrders().getArr();
        model.addObject("ordersObj", objects);
        logger.info("deleteOrder controller");
        return model;
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@ModelAttribute("orderId") int id){
        hotelsysService.removeOrder(id);
        logger.info("deleteOrder controller, id:" +id);
        return "redirect:/orders.html";
    }

    @RequestMapping(value = "/orders/{sort}")
    public ModelAndView getOrders(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("orders");
        ArrayList<Order> objects = hotelsysService.getAllOrders().getArr();
        if(sort.equals("id")){
            Collections.sort(objects, Order.idComparator);
        }
        if(sort.equals("customerId")){
            Collections.sort(objects, Order.customerComparator);
        }
        if(sort.equals("roomNumber")){
            Collections.sort(objects, Order.roomComparator);
        }
        model.addObject("ordersObj", objects);
        logger.info("getOrders");
        return model;
    }

    @RequestMapping("/users")
    public ModelAndView getUsers() {
        ModelAndView model = new ModelAndView("1");
        logger.info("Users");
        return model;
    }

    @RequestMapping("/customers/{sort}")
    public ModelAndView getCustomers(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("customers");
        ArrayList<Customer> objects = hotelsysService.getAllCustomer().getArr();
        if(sort.equals("id")){
            Collections.sort(objects, Customer.idComparator);
        }
        if(sort.equals("name")){
            Collections.sort(objects, Customer.nameComparator);
        }
        if(sort.equals("phoneNumber")){
            Collections.sort(objects, Customer.phoneComparator);
        }
        model.addObject("customersObj", objects);
        logger.info("getCustomers");
        return model;
    }

    @RequestMapping("/rooms/{sort}" )
    public ModelAndView getRooms(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("rooms");
        ArrayList<Room> objects = hotelsysService.getAllRooms().getArr();
        if(sort.equals("capacity")){
            Collections.sort(objects, Room.capacityComparator);
        }
        if(sort.equals("roomNumber")){
            Collections.sort(objects, Room.roomNumComparator);
        }
        if(sort.equals("price")){
            Collections.sort(objects, Room.priceComparator);
        }
        if(sort.equals("roomType")){
            Collections.sort(objects, Room.roomTypeComparator);
        }
        model.addObject("roomsObj", objects);
        logger.info("getRooms");
        return model;
    }

    @RequestMapping(value = "/freeRooms/{sort}")
    public ModelAndView freeRooms(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("freeRooms");
        ArrayList<Room> objects = hotelsysService.getFreeRooms().getArr();
        if(sort.equals("capacity")){
            Collections.sort(objects, Room.capacityComparator);
        }
        if(sort.equals("roomNumber")){
            Collections.sort(objects, Room.roomNumComparator);
        }
        if(sort.equals("price")){
            Collections.sort(objects, Room.priceComparator);
        }
        if(sort.equals("roomType")){
            Collections.sort(objects, Room.roomTypeComparator);
        }
        model.addObject("roomsObj", objects);
        logger.info("freeRooms");
        return model;
    }

    @RequestMapping("/1")
    public ModelAndView ajax(){
        ModelAndView model = new ModelAndView("1");
        logger.info("ajax");
        return model;
    }

    @RequestMapping("/res/")
    public ModelAndView res(){
        ModelAndView model = new ModelAndView("result");
        model.addObject("users", hotelsysService.getAllUsers().getArr());
        logger.info("res");
        return model;
    }

    @RequestMapping("/res/{sort}")
    public ModelAndView resSort(@PathVariable String sort){
        ModelAndView model = new ModelAndView("result");
        ArrayList<User> objects = hotelsysService.getAllUsers().getArr();
        if(sort.equals("id")){
            Collections.sort(objects, User.userIdComparator);
        }
        if(sort.equals("name")){
            Collections.sort(objects, User.nameComparator);
        }
        if(sort.equals("phoneNum")){
            Collections.sort(objects, User.phoneComparator);
        }
        if(sort.equals("roleId")){
            Collections.sort(objects, User.roleIdComparator);
        }
        if(sort.equals("mgrId")){
            Collections.sort(objects, User.managerIdComparator);
        }
        model.addObject("users", objects);
        logger.info("resSort");
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView model = new ModelAndView("error", "error",  e.getMessage());
        logger.info("handleException "+e.toString());
        return model;
    }
}