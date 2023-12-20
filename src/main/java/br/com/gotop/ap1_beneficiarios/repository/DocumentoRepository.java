package br.com.gotop.ap1_beneficiarios.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gotop.ap1_beneficiarios.model.Documento;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 21:50:28
 */
@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Integer> {

	Optional<Documento> findById(Integer id);
}
