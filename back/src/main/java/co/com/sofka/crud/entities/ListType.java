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
    private List<Todo> todosList;

    public ListType() {
        super();
        todosList = new ArrayList<Todo>();
    }

    public List<Todo> getTodosList() {
        return todosList;
    }
    public void addFactura(Todo todo) {
        todosList.add(todo);
    }

    public ListType(Long idList, String nameList, List<Todo> todoList) {
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
