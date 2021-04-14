import React from 'react';
import FormConfigGame from '../config/FormConfigGame';

const GameConfigView = () => {
    return (
        <div className="row m-2">
            <div className="col">
                <h2 className="m-3">🏁 Configurar nuevo juego 🏎 🏁</h2>
                <hr />
                <FormConfigGame />
            </div>

        </div>
    )
}

export default GameConfigView
