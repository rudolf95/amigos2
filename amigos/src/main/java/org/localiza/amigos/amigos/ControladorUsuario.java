package org.localiza.amigos.amigos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ControladorUsuario{
    @Autowired RepoUsuario repoUsuario;
    @GetMapping("/usuario")
    public List<Usuario> obtenerTodos(){

        return repoUsuario.findAll();
    }
    @GetMapping("/usuario/{id}")
    public Usuario buscarPorId(@PathVariable String id){
        return repoUsuario.findById(id).get();
    }
    @PostMapping("/usuario")
    public Estatus guardar(@RequestBody String json)throws Exception{
            ObjectMapper mapper=new ObjectMapper();
            Usuario u=mapper.readValue(json, Usuario.class);
            repoUsuario.save(u);
            Estatus estatus=new Estatus();
            estatus.mensaje="Se guardo el usuario";
            estatus.success=true;
            return estatus;
    }
}
