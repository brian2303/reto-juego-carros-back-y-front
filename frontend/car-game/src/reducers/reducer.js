import TYPES from '../actions/config-game.actions';


const reducer = (state, action) => {
    switch (action.type) {
        case TYPES.UPDATE_TRACKS:
            return { ...state, initialConfig: { ...state.initialConfig, tracks: action.payload } }
        case TYPES.ADD_TRACK:
            const listWithNewTrack = [...state.initialConfig.tracks, action.payload];
            return { ...state, initialConfig: { tracks: listWithNewTrack } }
        case TYPES.SET_PLAYERS:
            return { ...state, gameConfig: { quantityPlayers: parseInt(action.payload) } }
        case TYPES.UPDATE_DRIVERS:
            return { ...state, initialConfig: { ...state.initialConfig, drivers: action.payload } }
        default:
            return state;
    }
}

export default reducer;