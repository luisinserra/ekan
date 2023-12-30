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
 * 20 de dez. de 2023 00:31:38
 */
@Entity
@Table(name="ap1_beneficiario_documento")
public class BeneficiarioDocumento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_beneficiario", nullable = false)
	private Beneficiario beneficiario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_documento", nullable = false)
	private Documento documento;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
