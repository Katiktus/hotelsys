package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.RoomService;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class RoomController {
    @Autowired
    public RoomService roomService;
    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @RequestMapping("/deleteRoom")
    public ModelAndView deleteRoom(){
        ModelAndView model = new ModelAndView("deleteRoom");
        ArrayList<Room> objects = roomService.getAllRooms().getArr();
        model.addObject("roomsObj", objects);
        logger.info("deleteRoom controller objects:"+objects.toString());
        return model;
    }

    @PostMapping("/deleteRoom")
    public String deleteRoom(@ModelAttribute("roomNumber") int roomNumber){
        roomService.removeRoom(roomNumber);
        logger.info("roomNumber controller id:" + roomNumber);
        return "redirect:/rooms.html";
    }

    @GetMapping("/addRoom")
    public ModelAndView addRoomPage(){
        ModelAndView model = new ModelAndView("addRoom");
        logger.info("addRoom controller");
        return model;
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute("room") Room room){
        roomService.addRoom(room.getRoomType(), room.getCapacity(), room.getPrice(), room.getHotelID());
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
        roomService.updateRoomPrice(id, price);
        logger.info("updateRoomPrice controller, id:" +id+ " price:"+price);
        return "redirect:/rooms.html";
    }


    @RequestMapping("/rooms/{sort}" )
    public ModelAndView getRooms(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("rooms");
        ArrayList<Room> objects = roomService.getAllRooms().getArr();
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
        ArrayList<Room> objects = roomService.getFreeRooms().getArr();
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



}
