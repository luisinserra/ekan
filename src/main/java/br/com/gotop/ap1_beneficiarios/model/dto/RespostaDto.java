package br.com.gotop.ap1_beneficiarios.model.dto;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 14:25:30
 */
public class RespostaDto {

	private String resultado;
	private String mensagem;
	
	public RespostaDto() {}
	
	public RespostaDto(String resultado, String mensagem) {
		this.resultado = resultado;
		this.mensagem = mensagem;
	}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
