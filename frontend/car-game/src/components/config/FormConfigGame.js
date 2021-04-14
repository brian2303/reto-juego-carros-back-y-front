import React, { useContext, useEffect } from 'react'
import { Store } from '../../store';
import ModalNewTrack from './ModalNewTrack'
import TYPES from '../../actions/config-game.actions';
import ModalNewDriver from './ModalNewDriver';

const HOST_API = 'http://localhost:8080/api/v1'

const FormConfigGame = () => {
  const { state, dispatch } = useContext(Store);
  const { tracks, drivers } = state.initialConfig

  useEffect(() => {
    getAllTracks();
    getAllDrivers();
  }, [dispatch]);


  const getAllTracks = () => {
    fetch(`${HOST_API}/config/tracks`)
      .then(response => response.json())
      .then(response => {
        console.log(response)
        dispatch({ type: TYPES.UPDATE_TRACKS, "payload": response })
      })
  }

  const getAllDrivers = () => {
    fetch(`${HOST_API}/config/drivers`)
      .then(response => response.json())
      .then(response => {
        dispatch({ type: TYPES.UPDATE_DRIVERS, "payload": response })
      })
  }

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
          <div className="col-2" style={{ width: 50 }}>
            <ModalNewTrack />
          </div>
          <div className="col-3">
            <input type="number"
              onChange={(e) => dispatch({ type: TYPES.SET_PLAYERS, payload: e.target.value })}
              className="form-control"
              placeholder="Cantidad de jugadores..." />
          </div>
        </div>
        <div className="row mt-2">
          <div className="col-3">
            <select className="form-select" aria-label="pista">
              <option>Seleccione un jugador...</option>
              {drivers.map(driver => <option key={driver.id}>{driver.name}</option>)}
            </select>
          </div>
          <div className="col-2">
            <ModalNewDriver />
          </div>
        </div>
      </form>
    </div>
  )
}

export default FormConfigGame
