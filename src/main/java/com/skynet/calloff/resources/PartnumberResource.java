package com.skynet.calloff.resources;

import com.skynet.calloff.domains.Partnumber;
import com.skynet.calloff.services.PartnumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partnumbers")
@CrossOrigin
public class PartnumberResource {
  @Autowired
  private PartnumberService partnumberService;

  @GetMapping("/{status}")
  public List<Partnumber> listarStatus(@PathVariable String status){
    return partnumberService.buscarStatus(status);
  }
}