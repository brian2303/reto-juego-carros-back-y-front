import React, { createContext, useReducer } from "react";
import gameStartReducer from '../reducers/game-start.reducer';

const initialState = {
    listPlayersInGame: [],
    kmsTrack: 0,
    podium: []
};

export const GameStart = createContext(initialState)

const GameStartProvider = ({ children }) => {
    const [stateGame, dispatchGame] = useReducer(gameStartReducer, initialState);
    return (
        <GameStart.Provider value={{ stateGame, dispatchGame }}>
            {children}
        </GameStart.Provider>
    )
}

export default GameStartProvider;