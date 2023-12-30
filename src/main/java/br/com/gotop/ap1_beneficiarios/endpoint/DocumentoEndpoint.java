package br.com.gotop.ap1_beneficiarios.endpoint;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.gotop.ap1_beneficiarios.model.Documento;
import br.com.gotop.ap1_beneficiarios.model.dto.DocumentoDto;
import br.com.gotop.ap1_beneficiarios.model.dto.TiposDocumentoDto;
import br.com.gotop.ap1_beneficiarios.service.DocumentoService;
import br.com.gotop.ap1_beneficiarios.service.MapService;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 00:19:18
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/documentos")

public class DocumentoEndpoint {

	@Autowired
	DocumentoService documentoService;
	@Autowired
	MapService mapService;
	
	@PostMapping("/novoDocumento")
	public String novoDocumento(@RequestBody final DocumentoDto documento) {
		Documento documentoGravado = documentoService.incluirDocumento(documento);
		Gson gson = new Gson();
		String json = gson.toJson(documentoGravado);
		return json;
	}
	
	@GetMapping("/listarDocumentosDeBeneficiario")
	public List<Documento> listarDocumentosDeBeneficiario(@RequestParam(value = "idBeneficiario", required = true) final Integer idBeneficiario) {
		return documentoService.listarDocumentosDeBeneficiario(idBeneficiario);
	}
	
	@GetMapping("/trazerListagemDeTiposDeDocumento")
	public List<TiposDocumentoDto> trazerListagemDeTiposDeDocumento() {
		return documentoService.listarTiposDocumento();
	}
	
	@GetMapping("/buscarDocumentoPorBeneficiarioETipoDocumento")
	public Documento buscarDocumentoPorBeneficiarioETipoDocumento(@RequestParam(value = "idBeneficiario", required = true) final Integer idBeneficiario,
			@RequestParam(value = "tipoDocumento", required = true) final String tipoDocumento) {
		Documento retorno = documentoService.buscaDocumentoPorBeneficiarioETipo(idBeneficiario, tipoDocumento);
		if (retorno == null) {
			Documento documento = new Documento();
			documento.setDescricao("Erro: Documento não encontrado");
			return documento;
		}
		return retorno;
	}
	
	@PostMapping("/alterarDocumento")
	public JSONObject alterarDocumento(@RequestBody final Documento documento) {
		String retorno = documentoService.alterarDocumento(documento);
		String[][] dados = {{"retorno", retorno}};
		return new JSONObject(mapService.construirMapa(dados));
	}
	
	@DeleteMapping("/apagarDocumento/{idDocumento}")
	public JSONObject apagarDocumento(@PathVariable("idDocumento") Integer idDocumento) {
		String retorno = documentoService.apagarDocumento(idDocumento);
		if (!retorno.equals("Ok")) {
			retorno = "Erro excluindo documento";
		}
		String[][] dados = {{"retorno", retorno}};
		return new JSONObject(mapService.construirMapa(dados));
	}
}
