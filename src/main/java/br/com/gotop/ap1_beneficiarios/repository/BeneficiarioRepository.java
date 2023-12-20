package br.com.gotop.ap1_beneficiarios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gotop.ap1_beneficiarios.model.Beneficiario;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 18:20:06
 */
@Repository
public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Integer> {

	List<Beneficiario> findAllByOrderByNome();
	
	Optional<Beneficiario> findById(Integer id);
}
