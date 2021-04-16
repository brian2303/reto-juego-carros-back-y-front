import TYPES_GAME from '../actions/game-start.actions';

const gameStartReducer = (state, action) => {
    switch (action.type) {
        case TYPES_GAME.UPDATE_PLAYERS:
            const { players, kmsTrack } = action.payload;
            return { ...state, listPlayersInGame: players, kmsTrack: kmsTrack }
        case TYPES_GAME.UPDATE_PODIUM:
            return { ...state, podium: action.payload }
        case TYPES_GAME.SHOW_WINNERS:
            return { ...state, winners: action.payload }
        default:
            return state
    }
}

export default gameStartReducer;