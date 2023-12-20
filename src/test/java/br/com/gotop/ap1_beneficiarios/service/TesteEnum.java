package br.com.gotop.ap1_beneficiarios.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gotop.ap1_beneficiarios.repository.TipoDocumento;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 10:32:59
 */
@SpringBootTest
public class TesteEnum {

//	@Autowired
//	TipoDocumento tipoDocumento;
	
	@Test
	public void testeEnum() {
		for (DaysOfWeekEnum t: DaysOfWeekEnum.values()) {
			System.out.println(t.getTypeOfDay());
			System.out.println(t);
		}
		
		System.out.println("Stream");
		
		
		DaysOfWeekEnum.stream()
        .filter(d -> !d.getTypeOfDay().equals("off"))
        .forEach(System.out::println);


	}
	
	public enum DaysOfWeekEnum {
	    
	    SUNDAY("Domingo"), 
	    MONDAY("Segunda"), 
	    TUESDAY("Terça"), 
	    WEDNESDAY("Quarta"), 
	    THURSDAY("Quinta"), 
	    FRIDAY("Sexta"), 
	    SATURDAY("Sábado");

	    private String typeOfDay;

	    DaysOfWeekEnum(String typeOfDay) {
	        this.typeOfDay = typeOfDay;
	    }
		
	    // standard getters and setters 

	    public static Stream<DaysOfWeekEnum> stream() {
	        return Stream.of(DaysOfWeekEnum.values()); 
	    }

		public String getTypeOfDay() {
			return typeOfDay;
		}
	}
	
	@Test
	public void testeTiposDocumentos() {
		for (TipoDocumento t: TipoDocumento.values()) {
			System.out.println(t.getDescricao());
			System.out.println(t);
		}
		
	}
}
