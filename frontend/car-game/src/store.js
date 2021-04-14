import React, { createContext, useReducer } from "react";
import reducer from './reducers/reducer';

const initialState = {
    initialConfig: {
        tracks: [],
        drivers: [],
    },
    gameConfig: {
        gameName: null,
        quantityPlayers: null,
        trackId: 0,
        drivers: [],
    },
    gameList: []
};

export const Store = createContext(initialState)

const StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);
    return (
        <Store.Provider value={{ state, dispatch }}>
            {children}
        </Store.Provider>
    )
}

export default StoreProvider;