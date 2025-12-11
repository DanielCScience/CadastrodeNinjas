package dev.java10x.CadastrodeNinjas.Ninjas;

import dev.java10x.CadastrodeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//transforma a classe em entidade
//
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    //o id logo abaixo será detalhado como id da entidade e o generated gera uma estratégia para o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

   @Column(unique = true)
    private String email;

    @Column (name = "img_url")
   private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //@ManyToOne um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign key
    private MissoesModel missoes;

}
