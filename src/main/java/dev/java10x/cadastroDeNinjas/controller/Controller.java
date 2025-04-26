package dev.java10x.cadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combina @Controller e @ResponseBody. Serve para APIs REST que retornam JSON diretamente.
@RequestMapping // Mapeia uma URL para uma classe ou método. Pode ser usada para GET, POST, etc.
public class Controller {

    // @GetMapping
    // @PostMapping
    // @PutMapping
    // @DeleteMapping
    // Mapeiam requisições HTTP específicas para métodos do seu Controller. São especializações do @RequestMapping.

    @GetMapping()
    public String helloWord() {
        return "Hello world";
    }

    @GetMapping("/mensagem")
    public String boasVindas() {
        return "Boas Vindas a rota /mensagem";
    }

}
