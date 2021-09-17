package co.com.sofka.crud.dto;

import co.com.sofka.crud.entities.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodosListDto {

    private Long idList;
    private String nameList;
    private List<Todo> todosList;

    public TodosListDto() {
        super();
        todosList = new ArrayList<Todo>();
    }

    public List<Todo> getTodosList() {
        return todosList;
    }
    public void addFactura(Todo todo) {
        todosList.add(todo);
    }

    public TodosListDto(Long idList, String nameList, List<Todo> todoList) {
        this.idList = idList;
        this.nameList = nameList;
        todosList = new ArrayList<Todo>();
    }

    public Long getIdList() {
        return idList;
    }

    public void setIdList(Long idList) {
        this.idList = idList;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }
}
