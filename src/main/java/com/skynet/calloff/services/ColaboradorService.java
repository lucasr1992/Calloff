package com.skynet.calloff.services;

import com.skynet.calloff.domains.Colaborador;
import com.skynet.calloff.repositorys.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

  @Autowired
  private ColaboradorRepository colaboradorRepository;

  public List<Colaborador> listarStatus(String status){
    return colaboradorRepository.findListaByStatus(status);
  }

  public Colaborador buscar(String registro){
    return colaboradorRepository.findByRegistro(registro).orElseThrow(() -> new RuntimeException());
  }

  public Colaborador salvar(Colaborador colaborador){
    try{
      return colaboradorRepository.save(colaborador);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public void remover(String registro){
    try {
      colaboradorRepository.deleteByRegistro(registro);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public Colaborador login(String registro, String senha){
    return colaboradorRepository.findByRegistroAndSenha(registro, senha)
      .orElseThrow(() -> new RuntimeException());

  }
}
