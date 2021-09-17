package co.com.sofka.crud.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min = 3, message = "La tarea debe tener al menos tres carácteres")
    private String name;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name="List_type")
    private ListType listType;

    public Todo() {
        super();
    }

    public Todo(Long id, String name, boolean completed, ListType listType) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.listType = listType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }
}
