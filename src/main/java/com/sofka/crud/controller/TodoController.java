package com.sofka.crud.controller;

import com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;
}
