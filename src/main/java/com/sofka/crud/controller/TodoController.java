package com.sofka.crud.controller;

import com.sofka.crud.model.Todo;
import com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value="/todos")
    public Iterable<Todo> list(){ //Para listar todos los elementos
        return service.list();
    }

    @PostMapping(value = "/todo")
    public Todo save(@RequestBody Todo todo){ //Para guardar los elementos
        return service.save(todo);
    }

    @PutMapping(value="/todo")
    public Todo update(@RequestBody Todo todo){ //Para actualizar un elemento
        if(todo.getId() != null){
            return service.save(todo);
        } throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable("id") Long id){ //Para eliminar un elemento
        service.delete(id);
    }

    @GetMapping(value="/todo/{id}")
    public Todo get(@PathVariable("id") Long id){ //Para buscar por id
        return service.get(id);
    }
}
