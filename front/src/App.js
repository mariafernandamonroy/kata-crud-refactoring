import React, { useContext, useEffect, useRef, useState } from "react";
import TodoForm from "./TodoForm/TodoForm";
import List from "./List/List";
import { Store, StoreProvider } from "./Provider/Provider";

const HOST_API = "http://localhost:8080/api";

function App() {
  return (
    <StoreProvider>
      <h3>To-Do List</h3>
      <TodoForm />
      <List />
    </StoreProvider>
  );
}

export default App;
