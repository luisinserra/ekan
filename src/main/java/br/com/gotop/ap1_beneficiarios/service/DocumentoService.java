package br.com.gotop.ap1_beneficiarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Documento;
import br.com.gotop.ap1_beneficiarios.repository.DocumentoRepository;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 00:14:53
 */
@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository documentoRepository;
	
	public Documento incluirDocumento(Documento documento) {
		Documento documentoGravado = documentoRepository.save(documento);
		return documentoGravado;
	}
}
