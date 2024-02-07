package com.weescoelho.certification_nlw.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weescoelho.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.weescoelho.certification_nlw.modules.students.repositories.CertificationStudentRepository;

@Service // Define que a classe será um serviço e pode ser gerenciado pelo Spring boot
public class VerifyIfHasCertificationUseCase {

  @Autowired
  private CertificationStudentRepository certificationStudentRepository;

  public boolean execute(VerifyHasCertificationDTO dto) {

    var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),
        dto.getTechnology());

    if (!result.isEmpty()) {
      return true;
    }

    return false;
  }
}
