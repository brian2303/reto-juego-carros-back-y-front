import React from 'react';
import FormConfigGame from '../config/FormConfigGame';
import ListGame from '../config/ListGame';

const GameConfigView = () => {
    return (
        <>
            <div className="row m-2">
                <div className="col">
                    <h2 className="m-3">🏁 Configurar nuevo juego 🏎 🏁</h2>
                    <hr />
                    <FormConfigGame />
                </div>
            </div>
            <hr />
            <div className="row m-2">
                <ListGame />
            </div>
        </>
    )
}

export default GameConfigView
