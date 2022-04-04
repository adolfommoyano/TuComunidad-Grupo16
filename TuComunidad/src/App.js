import * as React from 'react';
import { Routes, Route, Link } from "react-router-dom";
import Votaciones from './routes/Votaciones';
import TuComunidad from './routes/TuComunidad';
import Reservas from './routes/Reservas';
import Foros from './routes/Foros';
import Conserjeria from './routes/Conserjeria';
import InicioSesion from './routes/InicioSesion';




export default function App() {
  return (
    <>
    <h1>TuComunidad</h1>
      <nav style={{ borderBottom: 'solid 1px', paddingBottom: '1rem' }}>
        <Link to="/TuComunidad">TuComunidad</Link> |{' '}
        <Link to="/Reservas">Reservas</Link> |{' '}
        <Link to="/Foros">Foros</Link> |{' '}
        <Link to="/Votaciones">Votaciones</Link> |{' '}
        <Link to="/Conserjeria">Conserjería</Link> |{' '}
        <Link to="/InicioSesion">Inicio de Sesión</Link> 
      </nav>
    <Routes>
      <Route path="TuComunidad" element={<TuComunidad />} />
      <Route path="Reservas" element={<Reservas />} />
      <Route path="Foros" element={<Foros/>} />
      <Route path="Votaciones" element={<Votaciones/>} />
      <Route path="Conserjeria" element={<Conserjeria/>} />
      <Route path="inicioSesion" element={<InicioSesion />} />
    </Routes>
    </>
  );
}