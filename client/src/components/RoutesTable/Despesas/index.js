import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import DespesaService from '../../../services/DespesaService'
import "./style.css"
import { MdModeEditOutline } from "react-icons/md";
import { AiFillDelete } from "react-icons/ai";


export function Despesas() {

    const [tipoDespesa, setTipoDespesa] = useState("")
    const [despesas, setDespesas] = useState([])

    useEffect(() => {
        if (tipoDespesa) {
            getFiltroPorTipo();
        } else {
            getAllDespesas();
        }

    }, [])

    const getAllDespesas = () => {
        DespesaService.getAllDespesas().then((response) => {
            setDespesas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const getFiltroPorTipo = () => {

        console.log(tipoDespesa)
        DespesaService.getFiltroPorTipo(tipoDespesa).then((response) => {
            setDespesas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteDespesa = (despesaId) => {
        DespesaService.deleteDespesa(despesaId).then((response) => {
            getAllDespesas();

        }).catch(error => {
            console.log(error);
        })

    }

    return (
        <div className='container'>
            <h2 className="text-center"> Lista de Despesas </h2>


            <input type="text " id='filtroTipo' placeholder='tipo de despesa' onChange={(e) => setTipoDespesa(e.target.value)} />
            <input type="button" value="filtrar" onClick={() => getFiltroPorTipo()} />
            <br /><br />

            <table className="table table-bordered table-striped" id='tableDespesa'>
                <thead>
                    <th> Despesa Id </th>
                    <th> valor </th>
                    <th> data pagamento </th>
                    <th> data pagamento esperado </th>
                    <th> tipo </th>
                    <th> Ações </th>
                </thead>
                <tbody>
                    {
                        despesas.map(
                            despesa =>
                                <tr key={despesa.id}>
                                    <td> {despesa.id} </td>
                                    <td> R${despesa.valor} </td>
                                    <td>{despesa.dataPagamento}</td>
                                    <td>{despesa.dataPagamentoEsperado}</td>
                                    <td>{despesa.tipoDespesa}</td>
                                    <td>
                                        <Link className="btn btn-info" to={`/despesaUp/${despesa.id}`} id='despesaUpdate' ><MdModeEditOutline /></Link>
                                        <button className="btn btn-danger" id='btn_despesa_delete' onClick={() => deleteDespesa(despesa.id)}
                                            style={{ marginLeft: "10px" }}
                                        ><AiFillDelete /> </button>
                                    </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

