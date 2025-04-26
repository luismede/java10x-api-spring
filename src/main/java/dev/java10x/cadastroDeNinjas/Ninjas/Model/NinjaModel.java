package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissaoModel;
import jakarta.persistence.*;

// JPA = Java Persistence API
@Entity // Transforma uma classe em uma entidade do BD
// "Spring/JPA, esta classe aqui representa uma tabela no banco de dados."
@Table(name = "tb_cadastro") // O @Table é usado para configurar detalhes específicos da tabela quando o mapeamento padrão (@Entity) não é suficiente.
public class NinjaModel {
    @Id // Informa ao java que o atributo logo a baixo dele deverá ser um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de IDs, informando que a geração será sequencial.
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Realizando o JOIN na tabela - "Mapeamento de tabelas"
    // missoes_id é a Foreign Key - Possui um mapa para dizer o que vem de uma tabela
    // Informa que muitos elementos (Missões) poderão conter um unico elemento (Ninja) da tabla.
    // @ManyToOne - MUITOS ninjas PARA UMA única missão.
    private MissaoModel missoes;

    public NinjaModel() {}

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
