import React, { createContext, useReducer } from "react";
import reducer from '../reducers/reducer';

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

export const StoreConfig = createContext(initialState)

const ConfigProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);
    return (
        <StoreConfig.Provider value={{ state, dispatch }}>
            {children}
        </StoreConfig.Provider>
    )
}

export default ConfigProvider;