package br.com.gotop.ap1_beneficiarios.model.dto;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 12:32:35
 */
public class TiposDocumentoDto {

	private String tipoDocumento;
	
	public TiposDocumentoDto() {}
	
	public TiposDocumentoDto(String tipo) {
		this.tipoDocumento = tipo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
