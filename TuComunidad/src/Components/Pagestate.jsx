import React, { Component } from 'react';

class Pagestate extends Component {

    render() {
        return (
            <div className="content container-fluid h-100">
                <div className='row' style={{border:"solid", height:200, background: "skyblue"}}>
                    <h2 align="center" style={{marginLeft: '12px', marginTop: '7px', }} >TuComunidad</h2>
                    <div className='col-md-4'> </div>
                </div>
                <div className='row' style={{height:30}}> </div>
                <div className='row' style={{height:40, background: "whitesmoke"}}>
                    <h5 align="center" style={{marginLeft: '12px', marginTop: '7px', }} >Nuestro Proyecto</h5>
                    <div className='col-md-4'> </div>
                </div>
                <div className='row' style={{height:20}}> </div>
                <div className='row' style={{height:40}}>
                    <div className='col-md-4' >
                        <div className='cellboard' style={{height:100}}>
                            <h3 align="center">Administración </h3>
                            <p>Control de los procedimientos internos que afectan a las comunidades </p>
                        </div>
                    </div>
                    <div className='col-md-4' >
                        <div className='cellboard' style={{height:100}}>
                            <h3 align="center">Simplicidad </h3>
                            <p>Nuestra página es simple e intuitiva para todo el mundo </p>
                        </div>
                    </div>
                    <div className='col-md-4'>
                        <div className='cellboard' style={{height:100}}>
                            <h3 align="center">Máximo Potencial </h3>
                            <p>Saca partido del potencial de tu instalación</p>
                        </div>
                    </div>
                </div>

            </div>
                )}
}

export default Pagestate;