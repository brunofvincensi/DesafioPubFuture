import "./style.css";

import { Link } from "react-router-dom";


export function Header() {
    return (

       

        <div className="header">

            <div><Link to={"/"} id="logo">
                financas pessoais</Link>
            </div>

            <ul>
            <li id="contas"><Link to={"/contas"}>Contas</Link></li>
            

            </ul>
            
        </div >
        
    );


}

