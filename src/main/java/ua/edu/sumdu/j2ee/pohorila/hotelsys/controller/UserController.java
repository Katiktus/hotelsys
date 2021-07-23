package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.UserService;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(){
        ModelAndView model = new ModelAndView("deleteUser");
        ArrayList<User> objects = userService.getAllUsers().getArr();
        model.addObject("usersObj", objects);
        logger.info("deleteUser controller, objects: "+objects.toString());
        return model;
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("userId") int userId){
        userService.removeUser(userId);
        logger.info("deleteUser controller id:" + userId);
        return "redirect:/users.html";
    }

    @GetMapping("/addUser")
    public ModelAndView addUserPage(){
        ModelAndView model = new ModelAndView("addUser");
        logger.info("addUser controller");
        return model;
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user")User user){
        userService.addUser(user.getName(), user.getManagerId(), user.getRoleId(), user.getPhoneNum(), user.getHotelID());
        logger.info("addUser controller, user:"+ user.toString());
        return "redirect:/users.html";
    }

    @GetMapping("/updateUserMgr")
    public ModelAndView updateUserMgrPage(){
        ModelAndView model = new ModelAndView("updateUserMgr");
        logger.info("updateUserMgr controller");
        return model;
    }

    @PostMapping("/updateUserMgr")
    public String updateUserMgr(@ModelAttribute("userId") int userId, @ModelAttribute("managerId") int mgrId){
        userService.updateUserMgr(userId, mgrId);
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
        userService.updateUserPhone(userId, phone);
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
        userService.updateUserRole(userId, roleId);
        logger.info("updateUserRole controller, id:" +userId+ " mgr:"+roleId);
        return "redirect:/users.html";
    }

    @RequestMapping("/users")
    public ModelAndView getUsers() {
        ModelAndView model = new ModelAndView("1");
        logger.info("Users");
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
        model.addObject("users", userService.getAllUsers().getArr());
        logger.info("res");
        return model;
    }

    @RequestMapping("/res/{sort}")
    public ModelAndView resSort(@PathVariable String sort){
        ModelAndView model = new ModelAndView("result");
        ArrayList<User> objects = userService.getAllUsers().getArr();
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
}
