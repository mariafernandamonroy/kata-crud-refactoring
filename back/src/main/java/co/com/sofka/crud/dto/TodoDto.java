package co.com.sofka.crud.dto;


public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;

    public TodoDto() {
        super();
    }

    public TodoDto(Long id, String name, boolean completed, String groupListId) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
