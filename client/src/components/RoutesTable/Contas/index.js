import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import ContaService from '../../../services/ContaService';
import "./style.css"
import { MdModeEditOutline } from "react-icons/md";
import { AiFillDelete } from "react-icons/ai";

export function Contas() {

    const [contas, setContas] = useState([])

    const [saldoTotal, setSaldoTotal] = useState("")

    useEffect(() => {

        getAllContas();
    }, [])

    useEffect(() => {

        ContaService.getSaldoTotal().then((response) =>{
            setSaldoTotal(response.data)

        }).catch(error => {
            console.log(error)
        })
    }, [])

    const getAllContas = () => {
        ContaService.getAllContas().then((response) => {
            setContas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteConta = (contaId) => {
        ContaService.deleteConta(contaId).then((response) => {
            getAllContas();

        }).catch(error => {
            console.log(error);
        })

    }



    return (
        <div className="container">

            <br />
            <Link to="/add-conta" className="btn btn-primary mb-2" id='addConta' > Adicionar Conta </Link>
            <br /><br />

             <div id='saldoTotal'>R$ {saldoTotal}</div>





            {
                contas.map(
                    conta =>
                        <div key={conta.id} id="conta-box">

                            <Link to="/conta" className='conta'>
                                <p id="tipoConta">Conta {conta.tipoConta}</p>
                                <p id="instituicao">{conta.instituicao}</p>
                                <p id="saldo"> R$ {conta.saldo}</p>
                            </Link>
                           
                                <Link  to={`/contaUp/${conta.id}`} className='botao' id='update' ><MdModeEditOutline /></Link>
                                
                                <button className='botao' id='delete' onClick={() => deleteConta(conta.id)}
                                    style={{ marginLeft: "10px" }}><AiFillDelete/> </button>
                            

                        </div>



                )
            }





        </div>


    )
}





