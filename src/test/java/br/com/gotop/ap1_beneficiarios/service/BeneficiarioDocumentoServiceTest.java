package br.com.gotop.ap1_beneficiarios.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.BeneficiarioDocumento;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioRepository;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 01:14:51
 */
@SpringBootTest
public class BeneficiarioDocumentoServiceTest {
	
	@Autowired
	BeneficiarioRepository beneficiarioRepository;
	@Autowired
	BeneficiarioDocumentoService beneficiarioDocumentoService;
	
	@Test
	public void trazDocumentosDoBeneficiarioTest() {
		int idBeneficiario = 5;
		List<BeneficiarioDocumento> lista = beneficiarioDocumentoService.trazDocumentosDoBeneficiario2(idBeneficiario);
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		System.out.println(json);
	}
}
