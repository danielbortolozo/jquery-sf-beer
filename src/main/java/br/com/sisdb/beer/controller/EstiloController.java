package br.com.sisdb.beer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sisdb.beer.model.Estilo;
import br.com.sisdb.beer.service.EstiloService;
import br.com.sisdb.beer.service.exception.NomeEstiloJaCadastradoException;


@Controller
public class EstiloController {

	@Autowired
	private EstiloService service;
	
	@RequestMapping("/estilo/novo")
	public ModelAndView novo (Estilo estilo) {
		ModelAndView mv =  new ModelAndView("estilo/cadastroEstilo");
		
		return mv;		
	}
	
	@RequestMapping(value = "/estilo/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model,
			RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
		   return novo(estilo);	
		}		
		
		try {		   
		    service.salvar(estilo);
		}catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso!");
		return new ModelAndView("redirect:/estilo/novo");	
	}
	
	@RequestMapping(value =  "/estilos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}		
		try {
			service.salvar(estilo);
		}catch (NomeEstiloJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(estilo);
	}
	
	
}
