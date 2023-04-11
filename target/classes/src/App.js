
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
import './App.css';
import Navbar from "./Components/Navbar/Navbar";
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { NavLink, Link } from "react-router-dom";
const Layout = () => <h1>Layouhjhjht</h1>;
function App() {
  return (
 
      <Router>
        <Routes>
          <Route path="/" element={<Home></Home>}></Route>
        </Routes>
      </Router>
    

  );

  
}
const Home = () => {

  return (
    <div className="App">
   <h1>ghghgh</h1>
     
      
    </div>
  );
};

export default App;
