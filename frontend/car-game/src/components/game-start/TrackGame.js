import React, { useContext, useEffect } from 'react'
import TYPES_GAME from '../../actions/game-start.actions'
import { GameStart } from '../../store/game-start.store'
import ModalPodium from './ModalPodium'
import WinnersLastGame from './WinnersLastGame';
import swal from 'sweetalert';

const HOST_API = 'http://localhost:8080/api/v1';


const TrackGame = () => {
  const MINIMUN_PLAYERS = 0;
  const { stateGame, dispatchGame } = useContext(GameStart)
  const playersInGame = stateGame.listPlayersInGame;
  const kmsTrack = stateGame.kmsTrack;
  const kmsTrackInMeters = kmsTrack * 1000;

  useEffect(() => {
    if (playersInGame.length > MINIMUN_PLAYERS) {
      fetch(`${HOST_API}/game/start`, {
        method: 'POST',
        body: JSON.stringify({ driversInGame: playersInGame, isFinished: false, kmsTrack }),
        headers: { 'Content-type': 'application/json' }
      })
        .then(response => response.json())
        .then(response => {
          if (response.finished) {
            dispatchGame({ type: TYPES_GAME.SHOW_WINNERS, payload: response.driversInGame })
            swal({ title: "Juego terminado", text: "Gracias por jugar", icon: "success", button: "Aceptar" })
          } else {
            dispatchGame({ type: TYPES_GAME.UPDATE_PLAYERS, payload: { players: response.driversInGame, kmsTrack: response.kmsTrack } })
          }
        })
    }
  }, [playersInGame]);

  const backGroundWinner = {
    color: 'green',
  }


  return (
    <>
      <table className="table">
        <thead>
          <tr>
            <th scope="col">PISTA DE JUEGO</th>
            <th scope="row"></th>
            <th scope="col">
              <ModalPodium />
            </th>
            <th scope="col">
              <WinnersLastGame />
            </th>
          </tr>
        </thead>
        <tbody>
          {playersInGame.map(player => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.brandCar}</td>
              <td>{player.modelCar}</td>
              <td style={player.score >= kmsTrackInMeters ? backGroundWinner : {}} >
                puntos :  {!player.score ? 0 : player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default TrackGame
