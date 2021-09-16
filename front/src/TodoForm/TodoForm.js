import React, { useContext, useRef, useState } from "react";
import { Store } from "../Provider/Provider";
import "./TodoForm.css";

const HOST_API = "http://localhost:8080/api";

function TodoForm() {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {

    const request = {
      name: state.name,
      id: null,
      completed: false,
    };

    fetch(HOST_API + "/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
    };

    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const handleSubmit = (event) => {
    
    event.preventDefault();
    if (!item.id) {
      onAdd()
    }else if(item.id){
      onEdit()
    }
  };

  return (
    <form ref={formRef} onSubmit={handleSubmit}>
      <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        required
        minlength="3"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}
      ></input>
      {item.id && (
        <button className="TodoForm_btn" type="submit">
          {" "}
          Actualizar{" "}
        </button>
      )}
      {!item.id && (
        <button className="TodoForm_btn" type="submit">
          {" "}
          Crear{" "}
        </button>
      )}
    </form>
  );
}

export default TodoForm;
