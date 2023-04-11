// importamos los estilos de boostrap
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
import "./App.scss";
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";


function App() {
    return (
      <Router>
        <div className="App">
          <Navbar />
        </div>
          <Routes>
        <Route path="/" element={<Home />} />
       
    
        </Routes>
      </Router>
    );
  }



  const Home = () => {
   
    return (
      <div className="App">
        <h1 className="text-center mb-3 Title">Capitulo</h1>
       
        
     

      </div>
    );
  };

  export default App;