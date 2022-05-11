import React, { Component } from 'react';
import {Link, Route, Routes} from "react-router-dom";
import VoteService from "../services/VoteService";
import DashboardService from "../services/DashboardService";


class Dashboard extends Component {

    constructor(props) {
        super(props);
        if (localStorage.getItem("id") == '' || localStorage.getItem("id") == undefined) {
            window.location.href = '/'
        }

        this.state = {
            numberOfVotes : 0,
            numberOfPackages : 0,
            reservedFacilityDTOS : []
        }

    }

    async getAllDashboardDetails() {
        await DashboardService.getAllDetails()
            .then((response) => {
                this.setState({numberOfVotes: response.data.votes})
                this.setState({numberOfPackages: response.data.packagesSize})
                this.setState({reservedFacilityDTOS: response.data.reservedFacilityDTOS})

                console.log(this.state.reservedFacilityDTOS)

            })
            .catch((error) => {
                console.log(error);
            });
    }

    componentDidMount() {


        this.getAllDashboardDetails().then(()=>{
            var canvas  = document.getElementById("chart");
            var chart = canvas.getContext("2d");

            function drawdountChart(canvas)
            {
                console.log("---")
                this.set = function( x, y, radius, from, to, lineWidth, strockStyle)
                {
                    this.x = x;
                    this.y = y;
                    this.radius = radius;
                    this.from=from;
                    this.to= to;
                    this.lineWidth = lineWidth;
                    this.strockStyle = strockStyle;
                }

                this.draw = function(data)
                {
                    canvas.beginPath();
                    canvas.lineWidth = this.lineWidth;
                    canvas.strokeStyle = this.strockStyle;
                    canvas.arc(this.x , this.y , this.radius , this.from , this.to);
                    canvas.stroke();
                    var numberOfParts = data.numberOfParts;
                    var parts = data.parts.pt;
                    var colors = data.colors.cs;
                    var df = 0; 

                    for(var i = 0; i<numberOfParts; i++) {
                        canvas.beginPath();
                        canvas.strokeStyle = colors[i];
                       
                        canvas.arc(this.x, this.y, this.radius, df, df + (Math.PI * 2) * (parts[i] / 100));
                        canvas.stroke();
                       
                        df += (Math.PI * 2) * (parts[i] / 100);
                    }
                }
            }

            var drawDount = new drawdountChart(chart);
            let points = [];
            let pointsColors = [];
            let colors = ["#dc1111", "#0c4a8b", "#e2cd1f", "#144718", "#100410"];

            this.state.reservedFacilityDTOS.map((reservedFacility,index) => {
                points.push(reservedFacility.totalReserved * 10)
                pointsColors.push(colors[index])
            });
            var data =
                {
                    numberOfParts: 3,
                    parts:{"pt": points},
                    colors:{"cs": pointsColors}
                };

            


            drawDount.set(150, 150, 100, 0, Math.PI*2, 30, "#FFF");
            drawDount.draw(data);


            this.state.reservedFacilityDTOS.map((reservedFacility,index) => {
                var c1 = document.getElementById(reservedFacility.facilityName);
                var ctx1 = c1.getContext("2d");
                ctx1.fillStyle = colors[index];
                ctx1.fillRect(5, 10, 5, 10);
            });

           


        });
    }

    render() {
        return(
            <div className='content'>
                <div className='row'>
                    <h2 style={{marginLeft: '12px', marginTop: '7px'}}>MiComunidad</h2>
                    <div className='col-md-4'>
                        <div className='cellboard'>
                            <p>Votos Activos</p>
                            <p>{this.state.numberOfVotes}</p>
                        </div>
                    </div>
                    <div className='col-md-4'>
                        <div className='cellboard'>
                            <p>Paquetes en Conserjería</p>
                            <p>{this.state.numberOfPackages}</p>
                        </div>
                    </div>
                    <div className='col-md-4'>
                        <div className='cellboard'>
                            <p>Votos Activos</p>
                            <p>2</p>
                        </div>
                    </div>
                </div>

                <div className='row sboarder' style={{ marginTop: '20px'}}>
                    <h2 style={{marginLeft: '12px', marginTop: '7px'}}>RESERVA INSTALACIONES</h2>
                    <div style={{width: '100%', margin: 'auto', marginTop: '20px'}} className='row'>

                        {this.state.reservedFacilityDTOS.map((reservedFacility,index) => (
                            <div className='col-md-4 c f'><canvas id={reservedFacility.facilityName} width={10} height={20} ></canvas>{reservedFacility.facilityName}</div>
                        ))}

                        {/*<div className='col-md-4 c f'><canvas id="1" width={10} height={20} ></canvas> Pistal de padel</div>*/}
                        {/*<div className='col-md-4 c f'><canvas id="2" width={10} height={20} ></canvas> Gimnasio</div>*/}
                        {/*<div className='col-md-4 c f'><canvas id="3" width={10} height={20} ></canvas> Mesa de ping pong</div>*/}

                    </div>
                    <div className='row'>
                        <div style={{textAlign: 'center'}}>
                            <canvas id="chart" width={300} height={300} style={{backgroundColor: '#fff'}}>  </canvas>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default Dashboard;