package br.com.gotop.ap1_beneficiarios.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.dto.BeneficiarioDto;
import br.com.gotop.ap1_beneficiarios.model.dto.RespostaDto;
import br.com.gotop.ap1_beneficiarios.service.BeneficiarioService;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 23:48:45
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioEndpoint {
	
	@Autowired
	BeneficiarioService beneficiarioService;

	@PostMapping("/novoBeneficiario")
	public String novoBeneficiario(@RequestBody final Beneficiario beneficiario) {
		Beneficiario beneficiarioGravado = beneficiarioService.incluirBeneficiario(beneficiario);
		Gson gson = new Gson();
		String json = gson.toJson(beneficiarioGravado);
		return json;
	}
	
	@GetMapping("/listaPaginadaDeBeneficiarios")
	public Page<BeneficiarioDto> listaPaginadaDeBeneficiarios(@RequestParam(value = "pagina", required = false) Integer pagina,
			@RequestParam(value = "tamanhoPagina", required = false) Integer tamanhoPagina) {
		if (pagina == null) {
			pagina = 0;
		}
		if (tamanhoPagina == null) {
			tamanhoPagina = 15;
		}
		
		Pageable pageable = PageRequest.of(pagina, tamanhoPagina);
		return beneficiarioService.trazerListaDeBeneficiarios(pageable);
	}
	
	@DeleteMapping("/apagaBeneficiario/{idBeneficiario}")
	public RespostaDto apagaBeneficiario(@PathVariable("idBeneficiario") Integer idBeneficiario) {
		RespostaDto respostaDto = beneficiarioService.apagarBeneficiario(idBeneficiario);
		return respostaDto;
	}
	
	@PostMapping("/alteraBeneficiario")
	public RespostaDto alteraBeneficiario(@RequestBody final Beneficiario beneficiario) {
		return beneficiarioService.alterarBeneficiario(beneficiario);
	}
	
	@GetMapping("buscarBeneficiarioPorId")
	public BeneficiarioDto buscarBeneficiarioPorId(@RequestParam(value = "idBeneficiario", required = false) Integer idBeneficiario) {
		BeneficiarioDto beneficiario = beneficiarioService.buscarBeneficiarioPorId(idBeneficiario);
		if (beneficiario == null) {
			BeneficiarioDto ben = new BeneficiarioDto();
			ben.setId(0);
			ben.setNome("Beneficiário não foi localizado");
			return ben;
		}
		return beneficiario;
	}
}
