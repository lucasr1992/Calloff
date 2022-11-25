package com.skynet.calloff.services;

import com.skynet.calloff.domains.Partnumber;
import com.skynet.calloff.repositorys.PartnumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnumberService {
  @Autowired
  private PartnumberRepository partnumberRepository;

  public List<Partnumber> buscarStatus(String status){
    return partnumberRepository.findByStatus(status);
  }
}
