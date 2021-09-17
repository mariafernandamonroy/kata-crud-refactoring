package co.com.sofka.crud.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="todosList")
public class TodosList {
    @Id
    @GeneratedValue
    private Long idList;
    private String nameList;
    @OneToMany(mappedBy = "todosList")
    private List<Todo> todosList;

    public TodosList() {
        super();
        todosList = new ArrayList<Todo>();
    }

    public List<Todo> getTodosList() {
        return todosList;
    }
    public void addTodo(Todo todo) {
        todosList.add(todo);
    }

    public TodosList(Long idList, String nameList, List<Todo> todoList) {
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
