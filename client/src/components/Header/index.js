import "./style.css";

import { Link } from "react-router-dom";


export function Header() {
    return (

       

        <div className="header">

            <div><Link to={"/"} id="logo">
                financas pessoais</Link>
            </div>

            <ul>
            <li id="contas" onClick={handleContasBold}><Link to={"/contas"}>Contas</Link></li>
            

            </ul>
            
        </div >
        
    );


}

function handleContasBold() {
    handleFontWeight();
    document.getElementById("contas").style.fontWeight = "bold";
}



function handleFontWeight() {
    document.getElementById("contas").style.fontWeight = "normal";
    
}