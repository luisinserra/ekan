package br.com.gotop.ap1_beneficiarios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.Documento;
import br.com.gotop.ap1_beneficiarios.model.dto.DocumentoDto;
import br.com.gotop.ap1_beneficiarios.model.dto.TiposDocumentoDto;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioRepository;
import br.com.gotop.ap1_beneficiarios.repository.DocumentoRepository;
import br.com.gotop.ap1_beneficiarios.repository.TipoDocumento;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 00:14:53
 */
@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository documentoRepository;
	@Autowired
	BeneficiarioRepository beneficiarioRepository;
	
	public Documento incluirDocumento(DocumentoDto documentoDto) {
		if (documentoDto.getIdBeneficiario() == null) {
			Documento docRetorno = new Documento();
			docRetorno.setDescricao("Erro: Beneficiário não foi localizado");
			return docRetorno;
		}
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(documentoDto.getIdBeneficiario());
		if (!opBeneficiario.isPresent()) {
			Documento docRetorno = new Documento();
			docRetorno.setDescricao("Erro: Beneficiário não foi localizado");
			return docRetorno;
		}
		Beneficiario beneficiario = opBeneficiario.get();
		String tipo = documentoDto.getTipoDocumento();
		String descricao = pegaDescricao(tipo);
		String valor = documentoDto.getValor();
		Documento documento = new Documento(tipo, descricao, beneficiario, valor);
		Optional<Documento> opDocumento = documentoRepository.findByBeneficiarioAndTipoDocumento(beneficiario, tipo);
		if (opDocumento.isPresent()) {
			documento = opDocumento.get();
			
		}
		Documento documentoGravado = documentoRepository.save(documento);
		return documentoGravado;
	}
	
	public Documento buscaDocumentoPorBeneficiarioETipo(Integer idBeneficiario, String tipoDocumento) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		if (!opBeneficiario.isPresent()) {
			return null;
		}
		Beneficiario beneficiario = opBeneficiario.get();
		Optional<Documento> opDocumento = documentoRepository.findByBeneficiarioAndTipoDocumento(beneficiario, tipoDocumento);
		if (opDocumento.isPresent()) {
			return opDocumento.get();
		} else {
			return null;
		}
	}
	
	public List<Documento> listarDocumentosDeBeneficiario(Integer idBeneficiario) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		if (opBeneficiario.isPresent()) {
			Beneficiario beneficiario = opBeneficiario.get();
			return documentoRepository.findByBeneficiario(beneficiario);
		} else {
			return null;
		}
	}
	
	public List<TiposDocumentoDto> listarTiposDocumento() {
		List<TiposDocumentoDto> retorno = new ArrayList<>();
		
		for (TipoDocumento t: TipoDocumento.values()) {
			String tipoDocumento = t.toString();
			String descricao = t.getDescricao();
			TiposDocumentoDto dto = new TiposDocumentoDto(tipoDocumento, descricao);
			retorno.add(dto);
		}
		return retorno;
	}
	
	public String pegaDescricao(String tipo) {
		String descricao = "";
		for (TipoDocumento t: TipoDocumento.values()) {
			if (t.toString().equals(tipo)) {
				descricao = t.getDescricao();
			}
		}
		return descricao;
	}
	
	public String alterarDocumento(Documento documento) {
		String retorno = "Ok";
		Integer id = documento.getId();
		Optional<Documento> opDocumento = documentoRepository.findById(id);
		if (opDocumento.isPresent()) {
			Documento documentoGravado = opDocumento.get();
			documentoGravado.setTipoDocumento(documento.getTipoDocumento());
			String descricao = pegaDescricao(documentoGravado.getTipoDocumento());
			documentoGravado.setDescricao(descricao);
			documentoGravado.setValor(documento.getValor());
			try {
				documentoRepository.save(documentoGravado);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = "nOk";
			}
		}
		return retorno;
	}
	
	public String apagarDocumento(Integer idDocumento) {
		String retorno = "Ok";
		Optional<Documento> opDocumento = documentoRepository.findById(idDocumento);
		if (!opDocumento.isPresent()) {
			retorno = "nOk";
			return retorno;
		}
		Documento documento = opDocumento.get();
		try {
			documentoRepository.delete(documento);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "nOk";
		}
		return retorno;
	}
}
