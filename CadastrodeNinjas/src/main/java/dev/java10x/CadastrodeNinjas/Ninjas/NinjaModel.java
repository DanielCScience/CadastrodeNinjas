package dev.java10x.CadastrodeNinjas.Ninjas;

import dev.java10x.CadastrodeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//transforma a classe em entidade
//
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    //o id logo abaixo será detalhado como id da entidade e o generated gera uma estratégia para o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign key
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
