package br.com.gotop.ap1_beneficiarios.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.repository.BeneficiarioRepository;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 23:25:49
 */
@SpringBootTest
public class BeneficiarioServiceTest {

	@Autowired
	BeneficiarioService beneficiarioService;
	
	@Test
	public void incluirBeneficiarioTest() throws ParseException {
		String nome = "Asdrubal Nascimento";
		String telefone = "(11) 9 3220-8522";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String sData = "27/12/2023 12:44";
		Date data = sdf.parse(sData);
		Beneficiario beneficiario = new Beneficiario(nome, telefone, data);
		Beneficiario beneficiarioGravado = beneficiarioService.incluirBeneficiario(beneficiario);
		Gson gson = new Gson();
		String json = gson.toJson(beneficiarioGravado);
		System.out.println(json);
	}
}
