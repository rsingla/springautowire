package com.techcodepro.service.impl;

import org.springframework.stereotype.Component;

import com.techcodepro.service.BaseInterface;

@Component(value = "impl2")
public class Implementation2 implements BaseInterface {

  @Override
  public String getMessage() {
    return "This is the second implementation call";
  }

}
