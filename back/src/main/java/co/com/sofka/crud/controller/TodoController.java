package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.service.TodoService;
import co.com.sofka.crud.entities.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> listAllTodos(){
        return service.listAllTodos();
    }
    
    @PostMapping(value = "api/todo")
    public Todo saveTodo(@Valid @RequestBody Todo todo) {
        return service.saveTodo(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo updateTodo(@Valid @RequestBody Todo todo){
        if(todo.getId() != null){
            return service.saveTodo(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id") Long id){
        service.deleteTodo(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoDto getTodo(@PathVariable("id") Long id){
        if(id != null) {
            return service.getTodo(id);
        }
        throw new RuntimeException("No existe el id");
    }

}
