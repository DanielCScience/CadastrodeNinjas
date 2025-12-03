package dev.java10x.CadastrodeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissao(){
        return"Missões listadas com sucesso";

    }

    //POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return"Missão criada com sucesso";
    }

    //PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return"Missão alterada com sucesso";
    }

    //DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return"Missão delatada com sucesso";
    }




}
