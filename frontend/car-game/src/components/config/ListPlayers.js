import React, { useContext, useEffect, useState } from 'react'
import { StoreConfig } from '../../store/config.store'

const ListPlayers = () => {
    const { state, dispatch } = useContext(StoreConfig)
    const [playersList, setplayersList] = useState([]);
    const driversGame = state.gameConfig.drivers;
    const drivers = state.initialConfig.drivers;

    useEffect(() => {
        driversGame.forEach(driverGame => {
            const findedPlayer = drivers.find(driver => driver.id === driverGame);
            setplayersList(playersList.concat(findedPlayer))
        });
    }, [driversGame]);


    return (
        <div className="row mt-2">
            {playersList.map(player => (
                <div key={player.id} className="col-3 mt-2">
                    <div key={player.ids} className="card" style={{ width: "18rem" }}>
                        <div className="card-body">
                            <h5 className="card-title">{player.name} 👤</h5>
                            <h6 className="card-subtitle mb-2">Vehiculo: {player.brandCar} 🚗</h6>
                            <span className="card-text text-muted">
                                Modelo: <strong>{player.modelCar}</strong>
                            </span>
                            <p>
                                Carril: <strong>{player.numberLane}</strong>
                            </p>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default ListPlayers
