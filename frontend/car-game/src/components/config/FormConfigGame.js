import React, { useContext, useEffect } from 'react'
import { StoreConfig } from '../../store/config.store';
import ModalNewTrack from './ModalNewTrack'
import TYPES from '../../actions/config-game.actions';
import ModalNewDriver from './ModalNewDriver';
import ListPlayers from './ListPlayers';

const HOST_API = 'http://localhost:8080/api/v1'

const FormConfigGame = () => {
  const { state, dispatch } = useContext(StoreConfig);
  const { tracks, drivers } = state.initialConfig


  useEffect(() => {
    getAllTracks();
    getAllDrivers();
  }, [dispatch]);

  const getAllTracks = () => {
    fetch(`${HOST_API}/config/tracks`)
      .then(response => response.json())
      .then(response => {
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

  const handleAddGame = (e) => {
    e.preventDefault()
    const request = state.gameConfig;
    fetch(`${HOST_API}/config/new/game`, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify(request)
    })
      .then(response => response.json())
      .then(response => console.log(response))
  }


  return (
    <div>
      <form>
        <div className="row">
          <div className="col-3">
            <select onChange={(e) => dispatch({ type: TYPES.SET_TRACK, payload: e.target.value })}
              className="form-select" aria-label="pista">
              <option>Seleccione una pista...</option>
              {tracks.map(track => <option value={track.id} key={track.id}>{track.name}</option>)}
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
            <select onChange={(e) => dispatch({ type: TYPES.ADD_PLAYER_TO_GAME, payload: parseInt(e.target.value) })}
              className="form-select" aria-label="pista">
              <option>Seleccione un jugador...</option>
              {drivers.map(driver => <option value={driver.id} key={driver.id}>{driver.name}</option>)}
            </select>
          </div>
          <div className="col-2" style={{ width: 50 }}>
            <ModalNewDriver />
          </div>
          <div className="col-3">
            <input type="text"
              onChange={(e) => dispatch({ type: TYPES.SET_NAME, payload: e.target.value })}
              className="form-control"
              placeholder="Asigne un nombre al juego..." />
          </div>
        </div>
        <ListPlayers />
        <button type="submit" onClick={handleAddGame} className="btn btn-outline-primary mt-2">Crear Juego</button>
      </form>
    </div>
  )
}

export default FormConfigGame
