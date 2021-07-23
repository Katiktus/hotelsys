package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelsysController {

    Logger logger = LoggerFactory.getLogger(HotelsysController.class);

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>Hello World, this is Tested Spring MVC</h3></div><br><br>";
        logger.info("welcome controller");
        return new ModelAndView("welcome", "message", message);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView model = new ModelAndView("error", "error",  e.getMessage());
        logger.info("handleException "+e.toString());
        return model;
    }
}