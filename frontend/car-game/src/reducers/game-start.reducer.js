import TYPES_GAME from '../actions/game-start.actions';

const gameStartReducer = (state, action) => {
    switch (action.type) {
        case TYPES_GAME.UPDATE_PLAYERS:
            const { players, kmsTrack } = action.payload;
            return { ...state, listPlayersInGame: players, kmsTrack: kmsTrack }
        default:
            return state
    }
}

export default gameStartReducer;