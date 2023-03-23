
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
import './App.css';
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { NavLink, Link } from "react-router-dom";
function App() {
  return (
    <div className="App">
   <nav className="navbar navbar-expand-lg navbar-light bg-light mb-4">
        <div className="container">
          <Link to="/" className="navbar-brand fs-3 ubuntu">
            Rick && Morty <span className="Title">APP</span>
          </Link>
          <style jsx>{`
            button[aria-expanded="false"] > .close {
              display: none;
            }
            button[aria-expanded="true"] > .open {
              display: none;
            }
          `}</style>
          <button
            className="navbar-toggler border-0"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="fas fa-bars open text-dark"></span>
            <span class="fas fa-times close text-dark"></span>
          </button>
          <div
            className="collapse navbar-collapse justify-content-end"
            id="navbarNavAltMarkup"
          >
           
          </div>
        </div>
      </nav>
    </div>
   

  );

  
}
const Home = () => {
  /*let [pageNumber, updatePageNumber] = useState(1);
  let [search, setSearch] = useState("");
  let [status, updateStatus] = useState("");
  let [gender, updateGender] = useState("");
  let [species, updateSpecies] = useState("");
  let [fetchedData, updateFetchedData] = useState([]);
  let { info, results } = fetchedData;
  let api = `https://rickandmortyapi.com/api/character/?page=${pageNumber}&name=${search}&status=${status}&gender=${gender}&species=${species}`;
    
// consumo de api
useEffect(() => {
  (async function () {
    let data = await fetch(api).then((res) => res.json());
    updateFetchedData(data);
  })();
}, [api]);*/
  return (
    <div className="App">
      <h1 className="text-center mb-3 Title">Capio</h1>
      <div className="container">
        <div className="row">
        
 <div className="col-lg-8 col-12">
            <div className="row">
            
            </div>
          </div>
          </div>
          </div>
     
      
    </div>
  );
};

export default App;
