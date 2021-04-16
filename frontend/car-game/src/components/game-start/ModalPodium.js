import React, { useContext } from 'react'
import TYPES_GAME from '../../actions/game-start.actions';
import { GameStart } from '../../store/game-start.store';
const HOST_API = 'http://localhost:8080/api/v1'

const ModalPodium = () => {
  const { stateGame, dispatchGame } = useContext(GameStart);
  const handlePodium = (e) => {
    e.preventDefault()
    fetch(`${HOST_API}/game/podium`)
      .then(response => response.json())
      .then(response => {
        dispatchGame({ type: TYPES_GAME.UPDATE_PODIUM, payload: response })
      })
  }
  return (
    <>
      <button type="button" onClick={handlePodium} className="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#modalPodium">
        Podios generales
      </button>
      <div className="modal fade" id="modalPodium" tabindex="-1" aria-labelledby="modalPodium" aria-hidden="true">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="modalPodium">Lista de podios</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div className="modal-body">
              <table className="table">
                <thead>
                  <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Victorias</th>
                  </tr>
                </thead>
                <tbody>
                  {stateGame.podium.map(p => (
                    <tr>
                      <th scope="row">{p.name}</th>
                      <td>{p.wonTimes}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-outline-primary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default ModalPodium
