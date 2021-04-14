import TYPES from '../actions/config-game.actions';


const reducer = (state, action) => {
    switch (action.type) {
        case TYPES.UPDATE_TRACKS:
            return { ...state, initialConfig: { tracks: action.payload } }
        case TYPES.ADD_TRACK:
            const listWithNewTrack = [...state.initialConfig.tracks, action.payload];
            return { ...state, initialConfig: { tracks: listWithNewTrack } }
        default:
            return state;
    }
}

export default reducer;