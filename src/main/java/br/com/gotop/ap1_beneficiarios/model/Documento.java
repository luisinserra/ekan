package br.com.gotop.ap1_beneficiarios.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 14:00:40
 */
@Entity
@Table(name="ap1_documento")
public class Documento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String tipoDocumento;
	private String descricao;
	private java.sql.Timestamp dataInclusao;
	private java.sql.Date dataAtualizacao;
	private String valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_beneficiario", nullable = false)
	private Beneficiario beneficiario;
	
	public Documento() {}
	
	public Documento(String tipoDocumento, String descricao, Beneficiario beneficiario, String valor) {
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.beneficiario = beneficiario;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public java.sql.Timestamp getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(java.sql.Timestamp dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public java.sql.Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(java.sql.Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
