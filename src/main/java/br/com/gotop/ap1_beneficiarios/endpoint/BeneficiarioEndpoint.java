package br.com.gotop.ap1_beneficiarios.endpoint;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.BeneficiarioDocumento;
import br.com.gotop.ap1_beneficiarios.service.BeneficiarioDocumentoService;
import br.com.gotop.ap1_beneficiarios.service.BeneficiarioService;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 23:48:45
 */
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
}
