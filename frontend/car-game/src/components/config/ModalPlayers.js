import React from 'react'
import ModalNewDriver from './ModalNewDriver'

const ModalPlayers = ({ players, gameId }) => {
  return (
    <>
      <button type="button" className="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target={`#modal${gameId}`}>
        Detalles 👤
      </button>
      <div className="modal fade" id={`modal${gameId}`} tabIndex="-1" aria-labelledby="modal-players-game" aria-hidden="true">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="modal-players-game">Ficha tecnica jugadores</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div className="modal-body">
              {players.map(player => (
                <div key={player.id}>
                  <p><strong>Jugador : </strong> {player.name}</p>
                  <p><strong>Marca del carro :</strong> {player.brandCar}</p>
                  <p><strong>Modelo :</strong> {player.modelCar}</p>
                  <p><strong># de carril :</strong> {player.numberLane}</p>
                  <hr />
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default ModalPlayers
