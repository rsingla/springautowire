package com.techcodepro.service.impl;

import org.springframework.stereotype.Component;

import com.techcodepro.service.BaseInterface;


@Component(value="impl1")
public class Implementation1  implements BaseInterface {

  @Override
  public String getMessage() {
    return "This is the first implementation call";
  }

}
