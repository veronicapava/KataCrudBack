package com.sofka.crud.service;

import com.sofka.crud.model.Todo;
import com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list(){ //Para listar todos los elementos
        return repository.findAll();
    }

    public Todo save(Todo todo){ //Para guardar los elementos
        return repository.save(todo);
    }

    public void delete(Long id){ //Para eliminar un elemento
        repository.delete(id);
    }

    public Optional<Todo> get(Long id){ //Para buscar por id
        return repository.findById(id);
    }


}