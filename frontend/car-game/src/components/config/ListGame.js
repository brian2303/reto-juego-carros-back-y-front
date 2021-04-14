import React from 'react'

const ListGame = () => {
  return (
    <>
      <h3>Lista de juegos</h3>
      <div className="col-6">
        <table class="table">
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
            <tr>
              <th scope="row">1</th>
              <td>Mark</td>
              <td>Otto</td>
              <td>12</td>
              <td>
                <button className="btn btn-sm btn-outline-primary">Detalles 👤</button>
              </td>
              <td>
                <button className="btn btn-sm btn-success">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-play-fill" viewBox="0 0 16 16">
                    <path d="m11.596 8.697-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z" />
                  </svg>
                    Iniciar
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </>
  )
}

export default ListGame
