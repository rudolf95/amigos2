package org.localiza.amigos.amigos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControladorHola {
@Autowired RepoHola repoHola;
    //aqui adentro van los metodos!! GET, POST, ETC.
    //el metodo get se usa para optner todos los registros guardados en la entidad
    @GetMapping("/hola")
    public List<Hola> holaMundo(){

        return repoHola.findAll();
    }
@GetMapping("/hola/{id}")
    public Hola buscarPorId (@PathVariable String id){
        Hola h=new Hola();
        if(repoHola.findById(id).isPresent()){
            h=repoHola.findById(id).get();
        }
        
        return h;
}
}
