import React, {useReducer , createContext} from 'react';
import reducer from '../Reducer/Reducer';

const initialState = {
  todo: { list: [], item: {} }
};
const Store = createContext(initialState)

function StoreProvider (props) {
  
  const [state, dispatch] = useReducer(reducer, initialState);
  
  return <Store.Provider value={{ state, dispatch }}>
    {props.children}
  </Store.Provider>

}

export {Store, StoreProvider};