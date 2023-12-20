package br.com.gotop.ap1_beneficiarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	public int id;
	public String tipoDocumento;
	public String descricao;
	public java.sql.Timestamp dataInclusão;
	public java.sql.Date dataAtualizacao;
	
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
	public java.sql.Timestamp getDataInclusão() {
		return dataInclusão;
	}
	public void setDataInclusão(java.sql.Timestamp dataInclusão) {
		this.dataInclusão = dataInclusão;
	}
	public java.sql.Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(java.sql.Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
