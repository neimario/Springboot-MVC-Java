package br.com.jcavi.javaweb.sisvendas.service;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.repository.ClienteRepository;
import br.com.jcavi.javaweb.sisvendas.repository.EnderecoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	public List<Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}

	public void salvar(Endereco endereco) {
		this.enderecoRepository.save(endereco);

	}
		

}