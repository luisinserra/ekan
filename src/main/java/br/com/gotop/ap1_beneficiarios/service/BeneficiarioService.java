package br.com.gotop.ap1_beneficiarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioRepository;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 23:14:57
 */
@Service
public class BeneficiarioService {
	
	@Autowired
	BeneficiarioRepository beneficiarioRepository;

	public Beneficiario incluirBeneficiario(Beneficiario beneficiario) {
		Beneficiario beneficiarioGravado = beneficiarioRepository.save(beneficiario);
		return beneficiarioGravado;
	}
	
	
}
