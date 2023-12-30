package br.com.gotop.ap1_beneficiarios.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gotop.ap1_beneficiarios.model.dto.TiposDocumentoDto;
import br.com.gotop.ap1_beneficiarios.service.TipoDocumentoService;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 12:20:22
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/documentos")
public class ListaTiposDocumentoEndpoint {
	
	@Autowired
	TipoDocumentoService tipoDocumentoService;

	@GetMapping("/listaTiposDocumento")
	public List<TiposDocumentoDto> listaTiposDocumento() {
		return tipoDocumentoService.listaTiposDocumento();
	}
}
