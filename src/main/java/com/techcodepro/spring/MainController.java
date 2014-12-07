package com.techcodepro.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techcodepro.service.BaseInterface;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);

  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "home";
  }

  @Autowired
  @Qualifier("impl1")
  BaseInterface impl1;

  @Autowired
  @Qualifier("impl2")
  BaseInterface impl2;

  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String implementationCall(Locale locale, Model model) {
    logger.info("Welcome to Main! The client locale is {}.", locale);

    model.addAttribute("Message1", impl1.getMessage());

    model.addAttribute("Message2", impl2.getMessage());

    return "main";
  }

}
