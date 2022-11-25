package com.skynet.calloff.resources;

import com.skynet.calloff.domains.Colaborador;
import com.skynet.calloff.services.ColaboradorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin
public class ColaboradorResource {
  @Autowired
  private ColaboradorService colaboradorService;

  @GetMapping("/{status}")
  public List<Colaborador> listarStatus(@PathVariable String status){
    return colaboradorService.listarStatus(status);
  }

  @GetMapping("/registro/{registro}")
  public Colaborador buscarColaborador(@PathVariable String registro){
    return colaboradorService.buscar(registro);
  }

  @PostMapping
  public Colaborador cadastrar(@RequestBody Colaborador colaborador){
    return colaboradorService.salvar(colaborador);
  }

  @PutMapping("/edit/{registro}")
  public Colaborador editar(@PathVariable String registro, @RequestBody Colaborador colaborador){
    Colaborador colaboradorEditar = colaboradorService.buscar(registro);
    BeanUtils.copyProperties(colaborador, colaboradorEditar, "registro", "nome");
    return colaboradorService.salvar(colaboradorEditar);
  }

  @DeleteMapping("/{registro}")
  public ResponseEntity<?> remover(@PathVariable String registro){
    try{
      colaboradorService.remover(registro);
      return ResponseEntity.noContent().build();
    }catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/login")
  public Colaborador login(@RequestBody Colaborador colaborador){

    return colaboradorService.login(colaborador.getRegistro(), colaborador.getSenha());

  }


}
