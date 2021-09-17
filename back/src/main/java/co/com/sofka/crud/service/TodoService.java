package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.dto.TodosListDto;
import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.entities.TodosList;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.repository.TodosListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodosListRepository todosListRepository;
    @Autowired
    private ModelMapper mapper;

    public Iterable<TodoDto> listAllTodos(){
        return StreamSupport
                .stream(todoRepository.findAll().spliterator(), false)
                .map(this::mapTodoToDto).collect(Collectors.toSet());
    }

    public Iterable<TodosListDto> listAllTodosList(){
        return StreamSupport
                .stream(todosListRepository.findAll().spliterator(), false)
                .map(this::mapTodosListToDto).collect(Collectors.toSet());
    }

    public TodosListDto findListById(Long idList){
        TodosList todosList = todosListRepository.findById(idList).orElseThrow();
        TodosListDto todosListDto = mapTodosListToDto(todosList);
        return todosListDto;
    }

    public TodosListDto saveTodosList(TodosListDto todosListDto){
        TodosList todosList =  mapTodosListDtoToEntity(todosListDto);
        Long id = todosListRepository.save(todosList).getIdList();
        todosListDto.setIdList(id);
        return todosListDto;
    }

    public TodoDto saveTodo(TodoDto todoDto, Long idList){
        Todo todo = mapTodoDtoToEntity(todoDto);
        Todo todoLocal = new Todo(todo.getId(), todo.getName(), todo.isCompleted());
        System.out.println(todoLocal);
        TodosList todosList = todosListRepository.findById(idList).orElseThrow();
        System.out.println(todosList);
        todosList.addTodo(todoLocal);
        TodosList todosListLocal = todosListRepository.save(todosList);
        int lastIndex = todosListLocal.getTodosList().size();
        Todo finalTodo =  todosListLocal.getTodosList()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        todoDto = mapTodoToDto(finalTodo);
        return todoDto;
    }


    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

//    public void deleteTodo(Long id){
//        Todo todo = todoRepository.findById(id).orElseThrow();
//        todoRepository.delete(todo);
//    }
//
//    public TodoDto getTodo(Long id){
//         return (TodoDto) todoRepository.findById(id)
//                 .stream()
//                 .map(this::mapTodoToDto)
//                 .collect(Collectors.toSet());
//    }
//
//    public TodosListDto getTodosList(Long idList){
//        return (TodosListDto) todoRepository.findById(idList)
//                .stream()
//                .map(this::mapTodoToDto)
//                .collect(Collectors.toSet());
//    }





    private TodoDto mapTodoToDto(Todo todo){
        TodoDto todoDto = mapper.map(todo, TodoDto.class);
        return todoDto;
    }
    private Todo mapTodoDtoToEntity(TodoDto todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);
        return todo;
    }
    private TodosListDto mapTodosListToDto(TodosList todosList){
        TodosListDto todosListDto = mapper.map(todosList, TodosListDto.class);
        return todosListDto;
    }
    private TodosList mapTodosListDtoToEntity(TodosListDto todoListDto){
        TodosList todosList = mapper.map(todoListDto, TodosList.class);
        return todosList;
    }
}
