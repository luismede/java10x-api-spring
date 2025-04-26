package dev.java10x.cadastroDeNinjas.Missoes.Model;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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
    // UMA missão PARA MUITOS ninjas.
    private List<NinjaModel> ninjas;

    public MissaoModel() {}

    public MissaoModel(Long id, String nomeMissao, String dificuldade) {
        this.id = id;
        this.nome = nomeMissao;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
