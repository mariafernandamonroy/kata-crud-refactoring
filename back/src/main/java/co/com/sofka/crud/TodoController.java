package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public Todo save(@Valid @RequestBody Todo todo){
        if(todo.getId() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para guardar");
    }

    @PutMapping(value = "api/todo")
    public Todo update(@Valid @RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id){
        if(id != null) {
            service.delete(id);
        }
        throw new RuntimeException("No existe el id");
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        if(id != null) {
            return service.get(id);
        }
        throw new RuntimeException("No existe el id");
    }

}
