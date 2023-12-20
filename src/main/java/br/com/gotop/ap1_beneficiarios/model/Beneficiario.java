package br.com.gotop.ap1_beneficiarios.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 13:49:31
 */
@Entity
@Table(name="ap1_beneficiario")
public class Beneficiario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nome;
	public String telefone;
	public java.util.Date dataNascimento;
	public java.sql.Timestamp dataInclusao;
	public java.util.Date dataAtualizacao;
	
	public Beneficiario() {}
	
	public Beneficiario(String nome, String telefone, Date dataNascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public java.util.Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public java.sql.Timestamp getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(java.sql.Timestamp dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public java.util.Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(java.sql.Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
