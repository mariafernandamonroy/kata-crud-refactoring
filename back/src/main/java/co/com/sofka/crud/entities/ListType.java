package co.com.sofka.crud.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ListType {
    @Id
    @GeneratedValue
    private Long idList;
    private String nameList;
    @OneToMany(mappedBy = "listType")
    private List<Todo> todoList;

    public ListType() {
        super();
        todoList = new ArrayList<Todo>();
    }

    public ListType(Long idList, String nameList, List<Todo> todoList) {
        this.idList = idList;
        this.nameList = nameList;
        this.todoList = todoList;
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

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
