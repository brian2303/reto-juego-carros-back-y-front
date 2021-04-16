import React, { useContext, useEffect } from 'react'
import TYPES_GAME from '../../actions/game-start.actions'
import { GameStart } from '../../store/game-start.store'

const HOST_API = 'http://localhost:8080/api/v1'

const TrackGame = () => {
  const { stateGame, dispatchGame } = useContext(GameStart)
  const playersInGame = stateGame.listPlayersInGame;

  useEffect(() => {
    if (playersInGame.length > 0) {
      fetch(`${HOST_API}/game/start`, {
        method: 'POST',
        body: JSON.stringify({ driversInGame: playersInGame, isFinished: false }),
        headers: { 'Content-type': 'application/json' }
      })
        .then(response => response.json())
        .then(response => {
          if (!response.finished) {
            dispatchGame({ type: TYPES_GAME.UPDATE_PLAYERS, payload: response.driversInGame })
          }
        })
    }
  }, [playersInGame]);



  return (
    <>
      <table className="table">
        <thead>
          <tr>
            <th scope="col"></th>
            <th scope="row">PISTA DE JUEGO</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {playersInGame.map(player => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.brandCar}</td>
              <td>{player.modelCar}</td>
              <td>puntos :  {!player.score ? 0 : player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default TrackGame
