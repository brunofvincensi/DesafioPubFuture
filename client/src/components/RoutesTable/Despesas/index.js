import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import DespesaService from '../../../services/DespesaService'
import "./style.css"
import { MdModeEditOutline } from "react-icons/md";
import { AiFillDelete } from "react-icons/ai";


export function Despesas() {

    const [tipoDespesa, setTipoDespesa] = useState("")
    const [dataInicial, setDataInicial] = useState("")
    const [dataFinal, setDataFinal] = useState("")
    const [despesas, setDespesas] = useState([])

    useEffect(() => {
        if (tipoDespesa) {
            getFiltroPorTipo();
        } if (dataInicial) {
            getFiltroPorData();
        }
        else {
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

    const getFiltroPorData = () => {

        DespesaService.getFiltroPorData(dataInicial, dataFinal).then((response) => {
            setDespesas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })     
    }

    const deleteDespesa = (despesaId) => {

        if (window.confirm("a despesa selecionada sera excluida"))

        {
        DespesaService.deleteDespesa(despesaId).then((response) => {
            getAllDespesas();

        }).catch(error => {
            console.log(error);
        })
        alert("despesa excluida")

    }

    }

    return (
        
        <div className='container'>
            <h2 className="text-center"> Lista de Despesas </h2>


            <form id='filtroTipo'>
                <input type="text " id='tipoFiltro' placeholder='tipo de despesa' onChange={(e) => setTipoDespesa(e.target.value)} />
                <input type="button" value="filtrar" onClick={() => getFiltroPorTipo()} />
            </form>

            <form id='filtroData'>

                <label>data inicial</label>
                <input type="date" id='dataInicial' placeholder='data incicial' onChange={(e) => setDataInicial(e.target.value)} />
                <label>data final</label>
                <input type="date" id='dataFinal' placeholder='data final' onChange={(e) => setDataFinal(e.target.value)} />
                <input type="button" value="filtrar" onClick={() => getFiltroPorData()} />

            </form>
            <br /><br />

            <table className="table table-bordered table-striped" id='tableDespesa'>
                <thead>
                    <th> nº da conta </th>
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
                                    <td> {despesa.contaId} </td>
                                    <td> R${despesa.valor} </td>
                                    <td>{despesa.dataPagamento}</td>
                                    <td>{despesa.dataPagamentoEsperado}</td>
                                    <td>{despesa.tipoDespesa}</td>
                                    <td>
                                        <Link className="btn btn-info" to={`/despesaUp/${despesa.id}`} id='btn-despesa-update' ><MdModeEditOutline /></Link>
                                        <button className="btn btn-danger" id='btn-despesa-delete' onClick={() => deleteDespesa(despesa.id)}
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

