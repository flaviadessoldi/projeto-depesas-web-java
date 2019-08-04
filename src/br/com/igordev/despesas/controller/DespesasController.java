package br.com.igordev.despesas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igordev.despesas.dao.DespesaDao;
import br.com.igordev.despesas.dao.JdbcDespesaDao;
import br.com.igordev.despesas.modelo.Despesa;

@Transactional
@Controller
public class DespesasController{
	
	@Autowired
	@Qualifier("jpaDespesaDao")
	private DespesaDao dao;

	 @Autowired
	 public DespesasController(JdbcDespesaDao dao) {
	 this.dao = dao;
	}
	 

		@RequestMapping("novaDespesa")
		public String form() {
			return "despesa/formulario";
		}

	
	@RequestMapping("adicionaDespesa")
	 public String adiciona(@Valid Despesa despesa, BindingResult result) {
		
		if (result.hasFieldErrors()) {
			 return "despesa/formulario";
			 }
		
	 dao.adiciona(despesa);
	 return "despesa/adicionada";
	 }
	
	 @RequestMapping("listaDespesas")
	 public String lista(Model model) {
	
	 List<Despesa> despesas = dao.lista();
	 model.addAttribute("despesas", despesas);
	 return "despesa/lista";
	 }
	 
	 @RequestMapping("removeDespesa")
	 public String remove(Despesa despesa) {
	 
	 dao.remove(despesa);
	 return "redirect:listaDespesas";
	 }
	 
	 @RequestMapping("mostraDespesa")
	 public String mostra(Long id, Model model) {
	
	 model.addAttribute("despesa", dao.buscaPorId(id));
	 return "despesa/mostra";
	 }
	 
	 @RequestMapping("alteraDespesa")
	 public String altera(Despesa despesa) {
	
	 dao.altera(despesa);
	 return "redirect:listaDespesas";
	 }
	 
	 @RequestMapping("quitarDespesa")
	 public String quitarDespesa(Long id, Model model) {
	
	 dao.quita(id);
	 model.addAttribute("despesa", dao.buscaPorId(id));
	 return "despesa/quitada";
	 }

}

