
import './App.css';
import AppRouter from './router/AppRouter';
import { Routes, Route } from "react-router-dom";


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/*" element={<AppRouter />} />
      </Routes>
    </div>
  );
}

export default App;
