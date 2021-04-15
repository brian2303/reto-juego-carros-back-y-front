import React, { useContext, useRef, useState } from 'react'
import { StoreConfig } from '../../store/config.store';
import TYPES from '../../actions/config-game.actions';

const HOST_API = 'http://localhost:8080/api/v1'

const ModalNewTrack = () => {
  const { state, dispatch } = useContext(StoreConfig);
  const [name, setName] = useState('')
  const [kms, setKms] = useState('')
  const formRef = useRef(null)

  const addTrack = (e) => {
    e.preventDefault();

    const request = {
      name,
      kms
    }

    fetch(`${HOST_API}/config/new/track`, {
      method: 'POST',
      body: JSON.stringify(request),
      headers: {
        'Content-type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(response => dispatch({ type: TYPES.ADD_TRACK, payload: response }))
    formRef.current.reset()
  }




  return (
    <span>
      <button type="button" className="btn btn-primary btn-md" data-bs-toggle="modal" data-bs-target="#modal-new-track">
        <i className="bi bi-plus-circle"></i>
      </button>
      <div className="modal fade" id="modal-new-track" tabIndex="-1" aria-hidden="true">
        <form ref={formRef}>
          <div className="modal-dialog">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLabel">Agregar pista 🛣</h5>
              </div>
              <div className="modal-body">
                <input type="text" onChange={(e) => setName(e.target.value)} placeholder="Nombre de la pista" />
                <input type="text" onChange={(e) => setKms(e.target.value)} placeholder="Longitud en kms..." />
              </div>
              <div className="modal-footer">
                <button type="button" onClick={addTrack} data-bs-dismiss="modal" className="btn btn-outline-primary">Registrar</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </span>
  )
}

export default ModalNewTrack
