import React, { useContext, useEffect } from 'react'
import { Store } from '../../store';
import ModalNewTrack from './ModalNewTrack'
import TYPES from '../../actions/config-game.actions';

const HOST_API = 'http://localhost:8080/api/v1'

const FormConfigGame = () => {
    const { state, dispatch } = useContext(Store);
    const { tracks } = state.initialConfig

    useEffect(() => {
        fetch(`${HOST_API}/config`)
            .then(response => response.json())
            .then(response => {
                dispatch({ type: TYPES.UPDATE_TRACKS, "payload": response })
            })
    }, [dispatch]);

    return (
        <div>
            <form>
                <div className="row">
                    <div className="col-3">
                        <select className="form-select" aria-label="pista">
                            <option>Seleccione una pista...</option>
                            {tracks.map(track => <option key={track.id}>{track.name}</option>)}
                        </select>
                    </div>
                    <div className="col">
                        <ModalNewTrack />
                    </div>
                </div>
            </form>
        </div>
    )
}

export default FormConfigGame
