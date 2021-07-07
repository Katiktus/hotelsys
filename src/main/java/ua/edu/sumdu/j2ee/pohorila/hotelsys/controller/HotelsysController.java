package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.HotelsysService;

@Controller
public class HotelsysController {

    @Autowired
    public HotelsysService hotelsysService;

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>Hello World, this is Tested Spring MVC</h3></div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }



}