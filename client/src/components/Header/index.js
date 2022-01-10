import "./style.css";

import { Link } from "react-router-dom";


export function Header() {
    return ( 

        <div className="header">

            <div><Link to={"/"} id="logo">
                finanças pessoais</Link>
            </div>

            <ul>
            <li><Link to={"/receitas"}>Receitas</Link></li>
            <li><Link to={"/despesas"}>Despesas</Link></li>
            </ul>
            
        </div >
        
    );


}

