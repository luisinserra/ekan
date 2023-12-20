package br.com.gotop.ap1_beneficiarios.model.dto;

import java.text.SimpleDateFormat;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 13:05:27
 */
public class BeneficiarioDto {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private int id;
	private String nome;
	private String telefone;
	private java.util.Date dataNascimento;
	private java.sql.Timestamp dataInclusao;
	private java.util.Date dataAtualizacao;
	private String dtNascimento;
	private String dtInclusao;
	private String dtAtualizacao;
	
	public BeneficiarioDto() {}
	
	public BeneficiarioDto(Beneficiario beneficiario) {
		this.id = beneficiario.getId();
		this.nome = beneficiario.getNome();
		this.telefone = beneficiario.getTelefone();
		this.dataNascimento = beneficiario.getDataNascimento();
		this.dataInclusao = beneficiario.getDataInclusao();
		this.dataAtualizacao = beneficiario.getDataAtualizacao();
		this.dtNascimento = dataNascimentoFormatada(beneficiario.getDataNascimento());
		this.dtInclusao = dataInclusaoFormatada(beneficiario.getDataInclusao());
		this.dtAtualizacao = dataAtualizacaoFormatada(beneficiario.getDataAtualizacao());
	}
	
	private String dataNascimentoFormatada(java.util.Date dataNascimento) {
		String dataNasc = sdf.format(dataNascimento).substring(0, 9);
		return dataNasc;
	}
	
	private String dataInclusaoFormatada(java.util.Date dataInclusao) {
		String dataInc = sdf.format(dataInclusao).substring(0, 9);
		return dataInc;
	}
	
	private String dataAtualizacaoFormatada(java.util.Date dataInclusao) {
		String retorno = "Ainda não atualizado";
		try {
			retorno = sdf.format(dataInclusao).substring(0, 9);
		} catch (Exception e) {}
		return retorno;
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
	public void setDataNascimento(java.util.Date dataNascimento) {
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
	public void setDataAtualizacao(java.util.Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(String dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	public String getDtAtualizacao() {
		return dtAtualizacao;
	}
	public void setDtAtualizacao(String dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}
}
