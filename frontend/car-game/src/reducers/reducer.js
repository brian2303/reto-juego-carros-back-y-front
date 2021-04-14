import TYPES from '../actions/config-game.actions';


const reducer = (state, action) => {
    switch (action.type) {
        case TYPES.UPDATE_TRACKS:
            return { ...state, initialConfig: { ...state.initialConfig, tracks: action.payload } }
        case TYPES.ADD_TRACK:
            const listWithNewTrack = [...state.initialConfig.tracks, action.payload];
            return { ...state, initialConfig: { ...state.initialConfig, tracks: listWithNewTrack } }
        case TYPES.ADD_DRIVER:
            const listWithNewDriver = [...state.initialConfig.drivers, action.payload]
            return { ...state, initialConfig: { ...state.initialConfig, drivers: listWithNewDriver } }
        case TYPES.UPDATE_DRIVERS:
            return { ...state, initialConfig: { ...state.initialConfig, drivers: action.payload } }
        case TYPES.SET_PLAYERS:
            return { ...state, gameConfig: { ...state.gameConfig, quantityPlayers: parseInt(action.payload) } }
        case TYPES.SET_NAME:
            return { ...state, gameConfig: { ...state.gameConfig, gameName: action.payload } }
        case TYPES.SET_TRACK:
            return { ...state, gameConfig: { ...state.gameConfig, trackId: parseInt(action.payload) } }
        case TYPES.ADD_PLAYER_TO_GAME:
            return { ...state, gameConfig: { ...state.gameConfig, drivers: [...state.gameConfig.drivers, action.payload] } }
        default:
            return state;
    }
}

export default reducer;