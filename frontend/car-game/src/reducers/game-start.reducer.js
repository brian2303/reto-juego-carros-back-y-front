import TYPES_GAME from '../actions/game-start.actions';

const gameStartReducer = (state, action) => {
    switch (action.type) {
        case TYPES_GAME.UPDATE_PLAYERS:
            return { ...state, listPlayersInGame: action.payload }
        default:
            return state
    }
}

export default gameStartReducer;