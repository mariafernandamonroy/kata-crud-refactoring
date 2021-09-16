import React, { useContext, useEffect } from 'react';
import { Store } from '../Provider/Provider';
import './List.css'

const HOST_API = "http://localhost:8080/api";

function List() {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/todos")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list })
      })
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", id })
    })
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo })
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completed: event.target.checked
    };
    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  const decorationDone = {
    textDecoration: 'line-through'
  };
  return <div>
    <table >
      <thead>
        <tr>
          <td>¿Completado?</td>
          <td>Tarea</td>
        </tr>
      </thead>
      <tbody>
        {currentList.map((todo) => {
          return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
            <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
            <td>{todo.name}</td>
            <td><button onClick={() => onEdit(todo)}>
            <img className="Icon" alt="edit" src="https://cdn-icons-png.flaticon.com/512/747/747825.png"></img>
              </button></td>
            <td><button onClick={() => onDelete(todo.id)}>
              <img className="Icon" alt="delete" src="https://cdn-icons-png.flaticon.com/512/5602/5602138.png"></img>
               </button></td>
            
          </tr>
        })}
      </tbody>
    </table>
  </div>
}

export default List;