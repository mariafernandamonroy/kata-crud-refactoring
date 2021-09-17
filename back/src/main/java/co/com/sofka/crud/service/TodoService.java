package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Todo> listAllTodos(){
        return repository.findAll();
    }

    public Todo saveTodo(Todo todo){
        return repository.save(todo);
    }

    public void deleteTodo(Long id){
        repository.delete(getTodo(id));
    }

    public Todo getTodo(Long id){
         return repository.findById(id).orElseThrow();
    }

}
