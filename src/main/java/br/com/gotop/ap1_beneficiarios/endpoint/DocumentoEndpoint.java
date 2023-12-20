package br.com.gotop.ap1_beneficiarios.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gotop.ap1_beneficiarios.model.Documento;
import br.com.gotop.ap1_beneficiarios.service.DocumentoService;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 00:19:18
 */
@RestController
@RequestMapping(value = "/documentos")

public class DocumentoEndpoint {

	@Autowired
	DocumentoService documentoService;
	
	@PostMapping("/novoDocumento")
	public String novoDocumento(@RequestBody final Documento documento) {
		Documento documentoGravado = documentoService.incluirDocumento(documento);
		Gson gson = new Gson();
		String json = gson.toJson(documentoGravado);
		return json;
	}
}
