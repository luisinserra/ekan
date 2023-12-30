package br.com.gotop.ap1_beneficiarios.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;
import br.com.gotop.ap1_beneficiarios.model.BeneficiarioDocumento;

/**
 * @author Luis Inserra
 *
 * 20 de dez. de 2023 00:40:09
 */
@Repository
public interface BeneficiarioDocumentoRepository extends CrudRepository<BeneficiarioDocumento, Integer> {

	List<BeneficiarioDocumento> findByBeneficiario(Beneficiario beneficiario);
	
}
