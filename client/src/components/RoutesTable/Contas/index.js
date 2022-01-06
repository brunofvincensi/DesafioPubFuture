import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import ContaService from '../../../services/ContaService';
import "./style.css"

export function Contas()  {

    const [contas, setContas] = useState([])

    useEffect(() => {

        getAllContas();
    }, [])

    const getAllContas = () => {
        ContaService.getAllContas().then((response) => {
            setContas(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    

    return (
        <div className = "container">
            
            <br/>
            <Link to = "/add-conta" className = "btn btn-primary mb-2" > Add Conta </Link>
            <br/><br/>
            <table className="table table-bordered table-striped">
                <thead>
                    <th> conta Id </th>
                    <th> Saldo </th>
                    <th> Tipo da Conta </th>
                    <th> Instituição </th>
          
                </thead>
                <tbody>
                    {
                        contas.map(
                            conta =>
                            <tr key = {conta.id}> 
                                <td> {conta.id} </td>
                                <td>{conta.saldo}</td>
                                <td>{conta.tipoConta}</td>
                                <td>{conta.instituicao}</td>                               
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}





