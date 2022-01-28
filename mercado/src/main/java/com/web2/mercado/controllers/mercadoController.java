package com.web2.mercado.controllers;

import com.web2.mercado.models.Produto;
import com.web2.mercado.repositories.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mercadoController {
    @Autowired
    MercadoRepository mercadoRepository;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto, Model model){
        mercadoRepository.save(produto);
        return "index";
    }
    @GetMapping("/mostrar")
    public String mostrar(Model model){
        Iterable<Produto> listaProduto = mercadoRepository.findAll();
        model.addAttribute("listaProduto", listaProduto);
        return "mostrar";
    }
}
