import React, { useContext } from 'react'
import { GameStart } from '../../store/game-start.store'

const WinnersLastGame = () => {
  const { stateGame, DispatchGame } = useContext(GameStart)
  return (
    <>
      <button type="button" className="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#winnersLastGame">
        Ganadores ultima partida
      </button>
      <div className="modal fade" id="winnersLastGame" tabindex="-1" aria-labelledby="winnersLastGame" aria-hidden="true">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="winnersLastGame">Ganadores ultima partida</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div className="modal-body">
              <table className="table">
                <thead>
                  <tr>
                    <th scope="col">Posicion</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Marca de carro</th>
                  </tr>
                </thead>
                <tbody>
                  {stateGame.winners.map((winner, idx) => (
                    <tr>
                      <th scope="row">{idx + 1}</th>
                      <th>{winner.name}</th>
                      <td>{winner.brandCar}</td>
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

export default WinnersLastGame
