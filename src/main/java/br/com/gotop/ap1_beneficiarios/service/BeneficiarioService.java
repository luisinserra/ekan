package br.com.gotop.ap1_beneficiarios.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.dto.BeneficiarioDto;
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
	
	public Beneficiario buscarBeneficiarioPorId(Integer idBeneficiario) {
		Optional<Beneficiario> opBeneficiario = beneficiarioRepository.findById(idBeneficiario);
		if (opBeneficiario.isPresent()) {
			return opBeneficiario.get();
		} else {
			return null;
		}
	}
	
	public Page<BeneficiarioDto> trazerListaDeBeneficiarios(Pageable pageable) {
		List<BeneficiarioDto> beneficiarios = new ArrayList<>();
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
//		for (Beneficiario benef: beneficiario) {
//			BeneficiarioDto dto = new BeneficiarioDto(benef);
//			beneficiarios.add(dto);
//		}
		return dtos;
	}
	
	private BeneficiarioDto beneficiarioToDto(Beneficiario beneficiario) {
		return new BeneficiarioDto(beneficiario);
	}
}
