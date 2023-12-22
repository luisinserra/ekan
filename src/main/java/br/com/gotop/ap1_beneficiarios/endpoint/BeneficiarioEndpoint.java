package br.com.gotop.ap1_beneficiarios.endpoint;

import java.util.List;

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
import br.com.gotop.ap1_beneficiarios.model.BeneficiarioDocumento;
import br.com.gotop.ap1_beneficiarios.model.dto.BeneficiarioDto;
import br.com.gotop.ap1_beneficiarios.model.dto.IdDto;
import br.com.gotop.ap1_beneficiarios.model.dto.RespostaDto;
import br.com.gotop.ap1_beneficiarios.service.BeneficiarioDocumentoService;
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
	@Autowired
	BeneficiarioDocumentoService beneficiarioDocumentoService;

	@PostMapping("/novoBeneficiario")
	public String novoBeneficiario(@RequestBody final Beneficiario beneficiario) {
		Beneficiario beneficiarioGravado = beneficiarioService.incluirBeneficiario(beneficiario);
		Gson gson = new Gson();
		String json = gson.toJson(beneficiarioGravado);
		return json;
	}
	
	@GetMapping("/beneficiarioComDocumentos")
	public String beneficiarioComDocumentos(@RequestParam(value = "idBeneficiario", required = true) final Integer idBeneficiario) {
		List<BeneficiarioDocumento> listaBeneficiariosComDocumentos = beneficiarioDocumentoService.trazDocumentosDoBeneficiario2(idBeneficiario);
		Gson gson = new Gson();
		String json = gson.toJson(listaBeneficiariosComDocumentos);
		return json;
	}
	
	@GetMapping("/buscarBeneficiarioPorId")
	public Beneficiario buscarBeneficiarioPorId(@RequestParam(value = "idBeneficiario", required = true) final Integer idBeneficiario) {
		return beneficiarioService.buscarBeneficiarioPorId(idBeneficiario);
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
}
