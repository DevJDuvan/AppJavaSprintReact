// importamos los estilos de boostrap
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
import "./App.scss";
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import Search from "./components/Search/Search";


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
    let [pageNumber, updatePageNumber] = useState(1);
    let [search, setSearch] = useState("");
    let [fetchedData, updateFetchedData] = useState([]);
    let [apos ,setapos]= useState('')
    let api = search;
    // cada vez que el url de la api cambie se actualiza la data
    useEffect(() => {
      (async function () {
        console.log(search)
        /*
        let data = await fetch(api).then((res) => res.json());
        updateFetchedData(data);*/
      })();
    }, [api]);
    return (
      <div className="App">
        <h1 className="text-center mb-3 Title">Consultar paises</h1>
       <Search setSearch={setSearch} updatePageNumber={updatePageNumber}/>
        
     

      </div>
    );
  };

  export default App;