import "./style.css";
import React, { useState } from "react";
import { Link } from "react-router-dom";


export function Header() {
    return (

       

        <div className="header">

            <div id="logo">
                financas pessoais
            </div>

            <ul>
            <li id="receitas" ><Link to={"/receitas"}>Receitas</Link></li>
            <li id="despesas" ><Link to={"/despesas"}>Despesas</Link></li>
            <li id="contas" ><Link to={"/contas"}>Contas</Link></li>
            </ul>

        
            
        </div >
        
    );


}