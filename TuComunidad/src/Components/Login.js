import React, { useState } from "react";

import "../assets/styles/login.css";
import LoginService from "../services/LoginService";
import {
    BrowserRouter, Link,
    Route, Router,
    Routes
} from "react-router-dom";
import {authenticate, authFailure, authSuccess} from "../redux/authActions";
import User from "./User";



const Login=({loading,error,...props})=>{
  
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [loginBy, setLoginBy] = useState("manager");


    const handleSubmit = (event) => {

        event.preventDefault();
        const {uname, pass} = document.forms[0];
        LoginService.login(uname.value, pass.value, loginBy)
            .then((response) => {
                if(response.data == null || response.data == '') {
                    setErrorMessages({ name: "error", message: response.data });
                } else {
                    debugger
                   
                        localStorage.setItem("id", response.data.id)
                        localStorage.setItem("name", response.data.name)
                        localStorage.setItem("loginBy", loginBy)
                 
                    window.location.href = '/dashboard'
                }
            });
       
    };

   
    const renderErrorMessage = (name) =>
        name === errorMessages.name && (
            <div className="error">{errorMessages.message}</div>
        );

    const handleChange = (event) => {
        const value = event.target.value
        setLoginBy(value)
    };

    const registerationForm = (
        <div className='container'>
            <div className='row header'>
                <nav>
                    <Link to="/user">Regístrate</Link>
                </nav>
            </div>
        </div>
    );

   
    const renderForm = (

        <div className="form">
            {renderErrorMessage("error")}
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Usuario </label>
                    <input className="login-field" type="text" name="uname" required />
                </div>
                <div className="input-container">
                    <label>Contraseña </label>
                    <input className="login-field" type="password" name="pass" required />
                </div>
                <div className="input-container">
                    <label>Has iniciado sesión como </label>
                    <select onChange={handleChange}>
                        <option selected value="manager">Gestor</option>
                        <option value="neighbour">Vecino</option>
                        <option value="concierge">Conserje</option>
                    </select>
                </div>
                <div className="row">
                    <div className="col-4">
                        <div className="button-container">
                            <input type="submit" />
                        </div>
                    </div>
                    <div className="col-4">
                        {registerationForm}
                    </div>
                </div>
            </form>
        </div>
    );

    return (

        <div className="app">

            <div style={{width: 500}} className="login-form">
                <div className="title">Sign In</div>
                {isSubmitted ? <div>User is successfully logged in</div> : renderForm}
            </div>
        </div>
    );
}


const mapStateToProps=({auth})=>{
    console.log("state ",auth)
    return {
        loading:auth.loading,
        error:auth.error
    }}


const mapDispatchToProps=(dispatch)=>{

    return {
        authenticate :()=> dispatch(authenticate()),
        setUser:(data)=> dispatch(authSuccess(data)),
        loginFailure:(message)=>dispatch(authFailure(message))
    }
}

export default Login;