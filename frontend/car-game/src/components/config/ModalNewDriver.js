import React, { useContext, useRef, useState } from 'react'
import { Store } from '../../store';
const HOST_API = 'http://localhost:8080/api/v1'

const ModalNewDriver = () => {
    const { state, dispatch } = useContext(Store);
    const formRef = useRef(null)
    const [name, setName] = useState('')
    const [brandCar, setBrandCar] = useState('')
    const [modelCar, setModelCar] = useState('');
    const [numberLane, setNumberLane] = useState('');

    const addPlayer = (e) => {
        e.preventDefault()
        const request = { name, brandCar, modelCar, numberLane }
        fetch(`${HOST_API}/config/new/driver`, {
            method: 'POST',
            body: JSON.stringify(request),
            headers: {
                'Content-type': 'application/json'
            },
        })
            .then(response => response.json())
            .then(response => console.log(response))
    }


    return (
        <span>
            <button type="button" className="btn btn-primary btn-md" data-bs-toggle="modal" data-bs-target="#modal-new-driver">
                <i className="bi bi-plus-circle"></i>
            </button>
            <div className="modal fade" id="modal-new-driver" tabIndex="-1" aria-hidden="true">
                <form ref={formRef}>
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Agregar conductor 🛣</h5>
                            </div>
                            <div className="modal-body">
                                <input type="text" onChange={(e) => setName(e.target.value)} placeholder="Nombre de el conductor..." />
                                <input type="text" onChange={(e) => setBrandCar(e.target.value)} placeholder="Marca del vehiculo..." />
                                <input type="text" onChange={(e) => setModelCar(e.target.value)} placeholder="Modelo del vehiculo..." />
                                <input type="text" onChange={(e) => setNumberLane(e.target.value)} placeholder="Numero de carril..." />
                            </div>
                            <div className="modal-footer">
                                <button type="button" onClick={addPlayer} data-bs-dismiss="modal" className="btn btn-outline-primary">Registrar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </span>
    )
}

export default ModalNewDriver
