package br.com.gotop.ap1_beneficiarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.BeneficiarioDocumento;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioDocumentoRepository;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioRepository;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 01:05:44
 */
@Service
public class BeneficiarioDocumentoService {

	@Autowired
	BeneficiarioRepository beneficiarioRepository;
	@Autowired
	BeneficiarioDocumentoRepository beneficiarioDocumentoRepository;
	
	public List<BeneficiarioDocumento> trazDocumentosDoBeneficiario2(Integer idBeneficiario) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		if (opBeneficiario.isPresent()) {
			Beneficiario beneficiario = opBeneficiario.get();
			List<BeneficiarioDocumento> lista = beneficiarioDocumentoRepository.findByBeneficiario(beneficiario);
			return lista;
		} else {
			return null;
		}
	}
}
