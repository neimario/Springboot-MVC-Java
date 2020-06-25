package br.com.jcavi.javaweb.sisvendas.controller;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import br.com.jcavi.javaweb.sisvendas.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/endereco")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class EnderecoController {
	private final EnderecoService enderecoService;
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("endereco/listar");
		List<Endereco> enderecos = enderecoService.listarTodos();
		mv.addObject("todosEnderecos", enderecos);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView carregaAdicionar(Endereco endereco) {
		ModelAndView mv = new ModelAndView("endereco/adicionar");
		mv.addObject("todosEnderecos", endereco);
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView adicionar(@Valid Endereco endereco, BindingResult result) {
		if(result.hasErrors()) {
			return carregaAdicionar(endereco);
		}
		enderecoService.salvar(endereco);
		return listar();
	}
	/*
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.obter(id);
		return carregaAdicionar(endereco);
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.obter(id);
		ModelAndView mv = new ModelAndView("endereco/detalhes");
		mv.addObject("endereco", endereco);
		return mv;	
	}

	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id")Long id) {
		Cliente cliente = this.clienteService.obter(id);
		this.clienteService.remover(endereco);
		return listar();		
	}

	*/
}