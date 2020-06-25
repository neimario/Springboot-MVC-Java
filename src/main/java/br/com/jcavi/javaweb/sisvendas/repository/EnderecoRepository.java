package br.com.jcavi.javaweb.sisvendas.repository;

import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
