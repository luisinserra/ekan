package br.com.gotop.ap1_beneficiarios.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gotop.ap1_beneficiarios.service.DocumentoService;

/**
 * @author Luis Inserra
 *
 * 26 de dez. de 2023 11:51:33
 */
public class DocumentoDto {
	
	@Autowired
	DocumentoService documentoService;

	private String tipoDocumento;
	private String descricao;
	private Integer idBeneficiario;
	private Integer acao;
	private String valor;
	
	public DocumentoDto() {}
	
	public DocumentoDto(String tipoDocumento, String descricao, Integer idBeneficiario) {
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.idBeneficiario = idBeneficiario;
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
	public Integer getIdBeneficiario() {
		return idBeneficiario;
	}
	public void setIdBeneficiario(Integer idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public Integer getAcao() {
		return acao;
	}

	public void setAcao(Integer acao) {
		this.acao = acao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
