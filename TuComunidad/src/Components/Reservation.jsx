import React, {Component} from 'react';
import DatePicker, {registerLocale} from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import "react-datepicker/dist/react-datepicker.css";
import TimePicker from "react-time-picker";
import ReserveFacilityService from "../services/ReserveFacilityService"
import FacilityService from "../services/FacilityService";
import Select from 'react-select'

class Reservation extends Component {

    constructor(props) {
        super(props);

        if (localStorage.getItem("id") == '' || localStorage.getItem("id") == undefined ||
            localStorage.getItem("loginBy") != 'neighbour') {
            window.location.href = '/'
        }

        this.state = {
            reservationDate: new Date(),
            neighbour: {idNeighbour : 1},
            facilities :  [],
            facility : {
                idFacilities : ''
            },
            idFacilities : 0,
            selectOptions : []
        }
        this.timeChange = this.timeChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    dateTimeChange = date => {
        this.setState({
            reservationDate: date
        })
    }

    timeChange = time => {
        this.setState({
            reservationTime: time
        })
    }

    async fetchFacilities() {
        console.log("fetchFacilities")
        const res =  await FacilityService.getFacilities()
            .then((response) => {
                const options = response.data.map(d => ({
                    "value" : d.idFacilities,
                    "label" : d.name
                }))
                this.setState({facilities: options})
            })
            .catch((error) => {
                console.log(error);
            });
    }

    handleChange(e){
        console.log(e)
        this.state.facility.idFacilities = e.value
    }

    async handleSubmit(event) {
        event.preventDefault();
        let neighbourId = localStorage.getItem("id")

        this.state.neighbour.idNeighbour = neighbourId
        
        ReserveFacilityService.saveReserveFacility(this.state)
            .then((response) => {
                console.log(response);
                alert('Record Saved Successfully!')
                
            })
            .catch((error) => {
                console.log(error);
                alert('Record Not Saved')
            });
            console.log("HOLAAAA"+this.state);
    }

    componentDidMount(){
        this.fetchFacilities()
    }

    render() {
        console.log("sdsdsds"+ this.state.facilities);
        console.log("estado:"+ this.state);
        return (
            <div className='content'>

                <div className='contenedor'>
                    <div className='center'>

                        <main style={{padding: '1rem 0'}}>
                            <h2>Reservas</h2>
                        </main>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <label>Calenderio:</label>
                                <DatePicker selected={this.state.reservationDate} onChange={this.dateTimeChange}
                                            showTimeSelect
                                            timeFormat="HH:mm"
                                            timeIntervals={30}
                                            timeCaption="time"
                                            dateFormat="yyyy-MM-dd h:mm aa"
                                            minDate={new Date()}
                                />
                            </div>

                            <br />

                            <div className="form-group">
                                <label>Instalación:</label>
                                <Select
                                    options={this.state.facilities}
                                    onChange={this.handleChange.bind(this)}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <button className="btn btn-success">Reservar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }

}

export default Reservation;