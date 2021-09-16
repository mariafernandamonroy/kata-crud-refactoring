import React from "react";

function reducer(state, action) {
  
  function updateItem() {
    const todoUpItem = state.todo;
    const listUpdateEdit = todoUpItem.list.map((item) => {
      if (item.id === action.item.id) {
        return action.item;
      }
      return item;
    });
    todoUpItem.list = listUpdateEdit;
    todoUpItem.item = {};
    return todoUpItem;
  }

  function deleteItem(){
    const todoUpDelete = state.todo;
      const listUpdate = todoUpDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.list = listUpdate;
    return todoUpDelete
  }

  function updateList(){
    const todoUpList = state.todo;
    todoUpList.list = action.list;
    return todoUpList
  }

  function editItem(){
    const todoUpEdit = state.todo;
    todoUpEdit.item = action.item;
    return todoUpEdit
  }

  function addItem(){
    const todoUp = state.todo.list;
    todoUp.push(action.item);
    return todoUp
  }

  switch (action.type) {
    case "update-item":
      return { ...state, todo: updateItem() };
    case "delete-item":
      return { ...state, todo: deleteItem() };
    case "update-list":
      return { ...state, todo: updateList() };
    case "edit-item":
      return { ...state, todo: editItem() };
    case "add-item":
      return { ...state, todo: { list: addItem(), item: {} } };
    default:
      return state;
  }
}

export default reducer;
