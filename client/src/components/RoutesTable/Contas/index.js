import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import ContaService from '../../../services/ContaService';
import "./style.css"
import { AiFillDelete } from "react-icons/ai";

export function Contas() {

    const [contas, setContas] = useState([])

    const [saldoTotal, setSaldoTotal] = useState("")

    useEffect(() => {

        getAllContas();
    }, [])

    useEffect(() => {

        ContaService.getSaldoTotal().then((response) => {
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
 
      
        if (window.confirm("a conta selecionada sera excluida"))
        {
            ContaService.deleteConta(contaId).then((response) => {
                getAllContas();
    
            }).catch(error => {
                console.log(error);
            })

            alert("conta excluida")
        
        }     

    }

    let saldoFinalFormated = new Number(parseFloat(saldoTotal))

    return (
        <div className="container">

            <br />
            <Link to="/add-conta" className="btn btn-primary mb-2" id='addConta' > Adicionar Conta </Link>
            <br /><br />

            <div id='saldoTotal'>R$ { saldoFinalFormated.toFixed(2)}
                <hr />
                <p>saldo total</p>

            </div>

            {
                contas.map(
                    conta =>
                        <div key={conta.id} id="conta-box">

                            <Link to={`/conta/${conta.id}`}>
                                <p id="tipoConta">Conta {conta.tipoConta}</p>
                                <p id="instituicao">{conta.instituicao}</p>
                                <p id="saldo"> R$ {conta.saldo}</p>
                                <p id='idConta'>nº {conta.id}</p>
                            </Link>

                            <br/><br/>

                            <button className='botao' id='delete' onClick={() => deleteConta(conta.id)}
                                style={{ marginLeft: "10px" }}><AiFillDelete /> </button>

                        </div>
                )
            }

        </div>


    )
}





