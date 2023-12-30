package br.com.gotop.ap1_beneficiarios.service;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.dto.BeneficiarioDto;
import br.com.gotop.ap1_beneficiarios.model.dto.RespostaDto;
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
	
	public BeneficiarioDto buscarBeneficiarioPorId(Integer idBeneficiario) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		if (opBeneficiario.isPresent()) {
			Beneficiario ben = opBeneficiario.get();
			BeneficiarioDto dto = new ModelMapper().map(ben, BeneficiarioDto.class);
			dto.setDtNascimento(new SimpleDateFormat("dd/MM/YYYY").format(dto.getDataNascimento()));
			dto.setDtInclusao(new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(dto.getDataInclusao()));
			String dataAtualizacao = "Ainda não atualizado";
			try {
				dataAtualizacao = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(dto.getDataAtualizacao());
			} catch (Exception e) {}
			dto.setDtAtualizacao(dataAtualizacao);
			return dto;
		} else {
			return null;
		}
	}
	
	public Page<BeneficiarioDto> trazerListaDeBeneficiarios(Pageable pageable) {
		Page<Beneficiario> beneficiario = beneficiarioRepository.findAllByOrderByNome(pageable);
		Page<BeneficiarioDto> dtos = beneficiario.map(b -> new ModelMapper().map(b, BeneficiarioDto.class));
		for (BeneficiarioDto dto: dtos) {
			dto.setDtNascimento(new SimpleDateFormat("dd/MM/YYYY").format(dto.getDataNascimento()));
			dto.setDtInclusao(new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(dto.getDataInclusao()));
			String dataAtualizacao = "Ainda não atualizado";
			try {
				dataAtualizacao = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(dto.getDataAtualizacao());
			} catch (Exception e) {}
			dto.setDtAtualizacao(dataAtualizacao);
		}
		return dtos;
	}
	
	public RespostaDto apagarBeneficiario(Integer idBeneficiario) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		RespostaDto resposta = null;
		if (!opBeneficiario.isPresent()) {
			resposta = new RespostaDto("Erro", "Registro não foi localizado");
			return resposta;
		} else {
			Beneficiario beneficiario = opBeneficiario.get();
			resposta = new RespostaDto("Ok", "");
			try {
				beneficiarioRepository.delete(beneficiario);
			} catch (Exception e) {
				resposta.setResultado("Erro");
				resposta.setMensagem("Erro apagando registro: " + e.getLocalizedMessage());
			}
		}
		return resposta;
	}
	
	public RespostaDto alterarBeneficiario(Beneficiario beneficiario) {
		RespostaDto resposta = null;
		Optional<Beneficiario> opBeneficiarioGravado = beneficiarioRepository.findById(beneficiario.getId());
		if (!opBeneficiarioGravado.isPresent()) {
			resposta = new RespostaDto("Erro", "Registro não foi localizado");
			return resposta;
		}
		Beneficiario beneficiarioGravado = opBeneficiarioGravado.get();
		resposta = new RespostaDto("Ok", "");
		beneficiarioGravado.setDataNascimento(beneficiario.getDataNascimento());
		beneficiarioGravado.setNome(beneficiario.getNome());
		beneficiarioGravado.setTelefone(beneficiario.getTelefone());
		try {
			beneficiarioRepository.save(beneficiarioGravado);
		} catch (Exception e) {
			resposta.setResultado("Erro");
			resposta.setMensagem("Erro apagando registro: " + e.getLocalizedMessage());
		}
		return resposta;
	}
}
