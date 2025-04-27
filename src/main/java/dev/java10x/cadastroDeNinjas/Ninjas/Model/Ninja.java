package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.java10x.cadastroDeNinjas.Missoes.Model.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA = Java Persistence API

@Entity // Transforma uma classe em uma entidade do BD
// "Spring/JPA, esta classe aqui representa uma tabela no banco de dados."

@Table(name = "tb_cadastro") // O @Table é usado para configurar detalhes específicos da tabela quando o mapeamento padrão (@Entity) não é suficiente.
@NoArgsConstructor
@AllArgsConstructor
@Data // Criando os Getter e Setters

public class Ninja {
    @Id // Informa ao java que o atributo logo a baixo dele deverá ser um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de IDs, informando que a geração será sequencial.
    private Long id;

    private String nome;
    private String email;
    private int idade;

    @ManyToOne
//    @JsonManagedReference // Gerenciar a referencia para evitar o circular reference
    @JoinColumn(name = "missoes_id") // Realizando o JOIN na tabela - "Mapeamento de tabelas"
    // missoes_id é a Foreign Key - Possui um mapa para dizer o que vem de uma tabela
    // Informa que muitos elementos (Missões) poderão conter um unico elemento (Ninja) da tabla.
    // @ManyToOne - MUITOS ninjas PARA UMA única missão.

    private MissaoModel missoes;

}
