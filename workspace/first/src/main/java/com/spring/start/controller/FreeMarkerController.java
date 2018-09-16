package com.spring.start.controller;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="freemarker")
public class FreeMarkerController {

    @RequestMapping(value="toDemo")
    public ModelAndView toDemo(ModelAndView mv){
     mv.addObject("name","jack");
     mv.setViewName("freemarker");
     return  mv;
    }
}
