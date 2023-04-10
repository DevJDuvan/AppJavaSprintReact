import React from "react";
import { NavLink, Link } from "react-router-dom";
import "../../App.css";

const Navbar = () => {
    return (
      <nav className="navbar navbar-expand-lg navbar-light bg-light mb-4">
        <div className="container">
      
         
       
          <div
            className="collapse navbar-collapse justify-content-end"
            id="navbarNavAltMarkup"
          >
            <div className="navbar-nav fs-5">
              <NavLink to="/" className="nav-link">
                Capitulos
              </NavLink>
              <NavLink to="/episodes" className="nav-link">
                Episodio
              </NavLink>
              <NavLink
                activeClassName="active"
                className="nav-link"
                to="/location"
              >
                Ubicacion
              </NavLink>
            </div>
          </div>
        </div>
      </nav>
    );
  };
  
  export default Navbar;