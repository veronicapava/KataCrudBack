package com.sofka.crud.controller;

import com.sofka.crud.model.Todo;
import com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value="api/todos")
    public Iterable<Todo> list(){ //Para listar todos los elementos
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){ //Para guardar los elementos
        return service.save(todo);
    }

    @PutMapping(value="api/todo")
    public Todo update(@RequestBody Todo todo){ //Para actualizar un elemento
        if(todo.getId() != null){
            return service.save(todo);
        } throw new RuntimeException("NO existe el id para actualizar");
    }

    @DeleteMapping("api/{id}/todo")
    public void delete(@PathVariable("id") Long id){ //Para eliminar un elemento
        service.delete(id);
    }

    @GetMapping(value="api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){ //Para buscar por id
        return service.get(id);
    }
}
