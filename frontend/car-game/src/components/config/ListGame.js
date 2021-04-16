import React, { useContext, useEffect } from 'react'
import TYPES from '../../actions/config-game.actions'
import TYPES_GAME from '../../actions/game-start.actions';
import { StoreConfig } from '../../store/config.store'
import { GameStart } from '../../store/game-start.store'
import ModalPlayers from './ModalPlayers'


const HOST_API = 'http://localhost:8080/api/v1'
const ListGame = () => {
  const { state, dispatch } = useContext(StoreConfig)
  const { stateGame, dispatchGame } = useContext(GameStart)

  const games = state.gameList

  useEffect(() => {
    fetch(`${HOST_API}/config/games`)
      .then(response => response.json())
      .then(response => dispatch({ type: TYPES.UPDATE_GAMES, payload: response }))
  }, [dispatch]);




  return (
    <>
      <h3>Lista de juegos</h3>
      <div className="col-6">
        <table className="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre del juego</th>
              <th scope="col">Pista</th>
              <th scope="col">Kms pista</th>
              <th scope="col">Jugadores</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            {games.map(game => (
              <tr key={game.gameId}>
                <th scope="row">{game.gameId}</th>
                <td>{game.gameName}</td>
                <td>{game.track.name}</td>
                <td>{game.track.kms}</td>
                <td>
                  <ModalPlayers players={game.drivers} gameId={game.gameId} />
                </td>
                <td>
                  <button onClick={(e) => dispatchGame({ type: TYPES_GAME.UPDATE_PLAYERS, payload: { players: game.drivers, kmsTrack: game.track.kms } })} className="btn btn-sm btn-success">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-play-fill" viewBox="0 0 16 16">
                      <path d="m11.596 8.697-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z" />
                    </svg>
                      Iniciar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  )
}

export default ListGame
