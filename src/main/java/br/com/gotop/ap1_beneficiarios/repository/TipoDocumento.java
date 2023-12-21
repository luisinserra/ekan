package br.com.gotop.ap1_beneficiarios.repository;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 10:23:22
 */
public enum TipoDocumento {

	RG("R.G."),
	CPF("Cpf"),
	CNH("Cnh"),
	ELEITOR("Título de Eleitor");
	
	private String descricao;

	TipoDocumento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
