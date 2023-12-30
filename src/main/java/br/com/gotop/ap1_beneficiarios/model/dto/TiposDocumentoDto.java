package br.com.gotop.ap1_beneficiarios.model.dto;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 12:32:35
 */
public class TiposDocumentoDto {

	private String tipoDocumento;
	private String descricao;
	
	public TiposDocumentoDto() {}
	
	public TiposDocumentoDto(String tipo, String descricao) {
		this.tipoDocumento = tipo;
		this.descricao = descricao;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
