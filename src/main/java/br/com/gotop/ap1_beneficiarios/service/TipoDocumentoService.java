package br.com.gotop.ap1_beneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gotop.ap1_beneficiarios.model.dto.TiposDocumentoDto;
import br.com.gotop.ap1_beneficiarios.repository.TipoDocumento;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 12:16:56
 */
@Service
public class TipoDocumentoService {

	public List<TiposDocumentoDto> listaTiposDocumento() {
		List<TiposDocumentoDto> listaDeTiposDeDocumentos = new ArrayList<>();
		
		for (TipoDocumento tipoDocumento: TipoDocumento.values()) {
			TiposDocumentoDto dto = new TiposDocumentoDto(tipoDocumento.getDescricao());
			listaDeTiposDeDocumentos.add(dto);
		}
		return listaDeTiposDeDocumentos;
	}
}
