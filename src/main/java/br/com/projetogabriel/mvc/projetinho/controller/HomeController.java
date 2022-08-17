package br.com.projetogabriel.mvc.projetinho.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetogabriel.mvc.projetinho.model.Pedido;
import br.com.projetogabriel.mvc.projetinho.model.StatusPedido;
import br.com.projetogabriel.mvc.projetinho.repository.PedidoRepository;



@Controller
@RequestMapping("/home")
public class HomeController {
      
      @Autowired
      private PedidoRepository pedidoRepository;

      @GetMapping
      public String home(Model model, Principal principal){

            List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
            model.addAttribute("pedidos", pedidos);
            return "home";
      }

}
