package dev.java10x.cadastroDeNinjas.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")

// Utilizando o Lombok
@NoArgsConstructor // Criando um construtor NoArgs
@AllArgsConstructor // Criando um construtor AllArgs
@Data // Criando os Getter e Setters

public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    /**
    * mappedBy define o lado NÃO dominante do relacionamento.
    * Ele indica qual atributo da outra entidade gerencia a associação.
    * Evita criação de tabelas intermediárias e controla a sincronização entre objetos Java e banco de dados.
    */

    @OneToMany(mappedBy = "missoes")
//    @JsonBackReference // <- Impede serialização para trás
    // UMA missão PARA MUITOS ninjas.
    @JsonIgnore
    private List<Ninja> ninjas;

}