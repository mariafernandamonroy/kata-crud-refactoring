package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.dto.TodosListDto;
import co.com.sofka.crud.entities.TodosList;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> listAllTodos(){
        return service.listAllTodos();
    }

    @GetMapping(value = "api/todoslist")
    public Iterable<TodosListDto> listAllTodosList(){
        return service.listAllTodosList();
    }

    @GetMapping(value = "api/{idList}/todoslist")
    public TodosListDto todosListDto(@PathVariable Long idList){
        return service.findListById(idList);
    }
    
    @PostMapping(value = "api/todoslist")
    public TodosListDto saveTodosList(@Valid @RequestBody TodosListDto todosListDto) {
        return service.saveTodosList(todosListDto);
    }

//    @PostMapping(value = "api/{idList}/todo")
//    public TodoDto saveTodo(@Valid @RequestBody TodoDto todoDto, @PathVariable Long idList ) {
//        return service.saveTodo(todoDto,idList);
//    }


//    @PutMapping(value = "api/todo")
//    public Todo updateTodo(@Valid @RequestBody Todo todo){
//        if(todo.getId() != null){
//            return service.saveTodo(todo);
//        }
//        throw new RuntimeException("No existe el id para actualizar");
//    }

//    @DeleteMapping(value = "api/{id}/todo")
//    public void deleteTodo(@PathVariable("id") Long id){
//        service.deleteTodo(id);
//    }
//
//    @GetMapping(value = "api/{id}/todo")
//    public TodoDto getTodo(@PathVariable("id") Long id){
//        if(id != null) {
//            return service.getTodo(id);
//        }
//        throw new RuntimeException("No existe el id");
//    }

}
