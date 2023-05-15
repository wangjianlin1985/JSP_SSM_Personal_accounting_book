// 
// 
// 

package com.taoxiuxia.controller;

import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/frameController" })
public class FrameController
{
    private Logger logger;
    
    public FrameController() {
        this.logger = LoggerFactory.getLogger((Class)FrameController.class);
    }
    
    @RequestMapping({ "/showframe" })
    public String frame(final Model model) {
        return "pages/frame";
    }
    
    @RequestMapping({ "/head" })
    public String head(final Model model) {
        return "pages/head";
    }
    
    @RequestMapping({ "/menu" })
    public String menu(final Model model) {
        return "pages/menu";
    }
}
