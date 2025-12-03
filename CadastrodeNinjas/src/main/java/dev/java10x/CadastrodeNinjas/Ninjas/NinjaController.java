package dev.java10x.CadastrodeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar nijnja (CREATE)
    @PostMapping("/criar")
    public String criarninja(){
        return "ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostar ninja";
    }

    //Mostrar ninja por id(READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar ninja por id";
    }

    //Alterar dados do ninja(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por id";
    }

    //Deletar ninja(DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "ninja deletado por id";
    }
}
