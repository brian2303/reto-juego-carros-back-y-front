import React from 'react';
import GameConfigView from "./components/views/GameConfigView";
import StoreProvider from './store';

const App = () => (
  <StoreProvider>
    <GameConfigView />
  </StoreProvider>
);

export default App;
