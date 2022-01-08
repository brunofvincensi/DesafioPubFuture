import "./style.css";

import { Link } from "react-router-dom";


export function Header() {
    return (

       

        <div className="header">

            <div><Link to={"/"} id="logo">
                financas pessoais</Link>
            </div>

            <ul>
            <li><Link to={"/recitas"}>Receitas</Link></li>
            <li><Link to={"/despesas"}>Despesas</Link></li>
            

            </ul>
            
        </div >
        
    );


}

