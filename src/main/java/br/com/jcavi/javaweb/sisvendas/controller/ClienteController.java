package br.com.jcavi.javaweb.sisvendas.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class ClienteController {
	private final ClienteService clienteService;

	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cliente/listar");
		List<Cliente> clientes = this.clienteService.listarTodos();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView carregaAdicionar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/adicionar");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView adicionar(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return carregaAdicionar(cliente);
		}
		clienteService.salvar(cliente);
		return listar();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.obter(id);
		return carregaAdicionar(cliente);
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.obter(id);
		ModelAndView mv = new ModelAndView("cliente/detalhes");
		mv.addObject("cliente", cliente);
		return mv;	
	}

	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id")Long id) {
		Cliente cliente = this.clienteService.obter(id);
		this.clienteService.remover(cliente);
		return listar();		
	}
}