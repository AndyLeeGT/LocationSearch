import { hot } from 'react-hot-loader/root';
import axios from "axios"
import React from 'react';
import ReactDOM from 'react-dom';
import LoginScreen from "./components/LoginScreen"; 

const title = 'React with Webpack and Babel';
ReactDOM.render(<LoginScreen ></LoginScreen>, document.getElementById("app"))