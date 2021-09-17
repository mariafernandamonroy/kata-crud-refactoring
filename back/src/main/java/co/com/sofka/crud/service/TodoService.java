package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.todoRepository.TodotodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper mapper;

    public Iterable<TodoDto> listAllTodos(){
        return StreamSupport
                .stream(todoRepository.findAll().spliterator(), false)
                .map(this::mapTodoToDto).collect(Collectors.toSet());
    }

    public TodoDto saveTodo(Todo todo){
        TodoDto todoDto = getTodo(todo.getId());
        return todoRepository.save(todoDto);
    }

    public void deleteTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow();
        todoRepository.delete(todo);
    }

    public TodoDto getTodo(Long id){
         return (TodoDto) todoRepository.findById(id)
                 .stream()
                 .map(this::mapTodoToDto)
                 .collect(Collectors.toSet());
    }

    private TodoDto mapTodoToDto(Todo todo){
        TodoDto todoDto = new TodoDto();
        todoDto = mapper.map(todo, TodoDto.class);
        return todoDto;
    }
    private Todo mapTodoDtoToEntity(TodoDto todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);
        return todo;
    }

}
