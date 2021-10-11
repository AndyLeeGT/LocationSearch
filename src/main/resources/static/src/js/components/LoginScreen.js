import React, { useState } from 'react';
import axios from "axios"
import {
    useHistory,
    useLocation
} from "react-router-dom";

import "../../css/login_page_structure.css"

const LoginScreen = ({ auth }) => { 
    const [name, setName] = useState("")
    const [password, setPassword] = useState("")

    let history = useHistory();
    let location = useLocation();

    let { from } = location.state || { from: { pathname: "/" } };

    const activateLasers = (e) => { 
        e.preventDefault();
        axios.post("http://localhost:8080/users",{ "username": name, "password": password})
        .then(val => history.replace(from))
        .catch(err => console.log(err))
    }
    return <div className= "log_in_class" style={{}}>
        <section id = "log_in_content">
            <form onSubmit={activateLasers} >
            <h1> LOGIN PAGE </h1>
            {/* <!-- UserName contents--> */}
            <div id = "log_in_userName">
                <input type="text" placeholder="username" value={name} onChange={e => setName(e.target.value)} id="username" name = "username" />
            </div>
            {/* <!-- password contents--> */}
            <div id = "log_in_password">
                <input type="password" placeholder="password" value={password} onChange={e => setPassword(e.target.value)} required= "" id="password" name = "password"/>
            </div>
            <input type="submit" id="submitbutton" value="Log In"></input>
            <div>
                <a href="create_account.html">Need an account? </a>
            </div>
            </form>
        </section>
    </div>
}
export default LoginScreen;