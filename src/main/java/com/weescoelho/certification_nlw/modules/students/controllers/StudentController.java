package com.weescoelho.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weescoelho.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.weescoelho.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // Define que esta classe é um Controller REST
@RequestMapping("/students") // Mapeamento da rota
public class StudentController {

  @Autowired // Faz a injeção de dependencia do use case
  private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @PostMapping("/verifyIfHasCertification")
  public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO entity) {
    var result = this.verifyIfHasCertificationUseCase.execute(entity);

    if (result) {
      return "Usuário ja fez  prova";
    }

    return "Usuario pode fazer a prova";
  }

}
