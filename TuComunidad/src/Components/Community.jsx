
import React, { Component } from 'react';
import {Link} from 'react-router-dom'

class Community extends Component {
    render() {
        return (
            <div className='content'>
            <div className='row'>
                <div className='col-md-4 '>
                    <div>
                        <h2 style={{fontSize: '30px', color: '#757575', marginBottom: '35px'}}>Foros de la Comunidad</h2>
                    </div>
                    <table style={{width: '250px'}}>
                        <tr style={{ backgroundColor: 'white'}}>
                            <td><a href='#'>Foro: Reforma del Garaje</a></td>
                        </tr>
                        <tr>
                            <td><a href='#'>Foro: Ampliación horario piscina</a></td>
                        </tr>
                       
                    </table>
                </div>
                <div className='col-md-8'>
                    <div className='chat-box row' style={{marginLeft: '0px', marginRight: '0px'}}>
                        <div className='col-md-9 records'>
                            <p>Foro: Reforma del garaje</p>
                            <div className='record'>
                                <h2><a href='#'>Juan</a></h2>
                                <p>Hola vecinos</p>
                            </div>
                            <div className='record'>
                                <h2><a href='#'>Andrés</a></h2>
                                <p>Hola Juan!!</p>
                            </div>
                            <div className='record'>
                                <h2><a href='#'>Adolfo</a></h2>
                                <p>Juan! Cómo estás?</p>
                            </div>
                            <div className='record'>
                                <h2><a href='#'>Juan</a></h2>
                                <p>Os escribo por el tema de la reforma de la piscina</p>
                            </div>
                            <div className='record'>
                                <h2><a href='#'>Adolfo</a></h2>
                                <p>Hola chicos! Soy todo oídos Juan!</p>
                            </div>
                            <div className='record'>
                                <h2><a href='#'>Jaime</a></h2>
                                <p>Hola a todos!!</p>
                            </div>
                        </div>
                       
                    </div>
                    <div className='chat-input'>
                        <div className='row'>
                            <input type="text" class="form-control cinput col-md-3" id="usr"/>
                            <input type='button' value="Enviar" className='cbutton col-md-2' style={{width: '70px', height: '36px'}}></input>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        );
      }
}

export default Community;