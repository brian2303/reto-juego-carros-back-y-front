import React from 'react';
import GameConfigView from "./components/views/GameConfigView";
import ConfigProvider from './store/config.store';
import GameStartProvider from './store/game-start.store';


const App = () => (
  <ConfigProvider>
    <GameStartProvider>
      <GameConfigView />
    </GameStartProvider>
  </ConfigProvider>
);

export default App;
