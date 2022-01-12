import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import ReceitaService from '../../../services/ReceitaService'
import "./style.css"
import { MdModeEditOutline } from "react-icons/md";
import { AiFillDelete } from "react-icons/ai";


 export function Receitas () {

    const [receitas, setReceitas] = useState([])

    const [dataInicial, setDataInicial] = useState("")
    const [dataFinal, setDataFinal] = useState("")
    const [tipoReceita, setTipoReceita] = useState("")

    useEffect(() => {

        getAllReceitas();
    }, [])

    const getAllReceitas = () => {
        ReceitaService.getAllReceitas().then((response) => {
            setReceitas(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const getFiltroPorTipo = () => {

        console.log(tipoReceita)
        ReceitaService.getFiltroPorTipo(tipoReceita).then((response) => {
            setReceitas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const getFiltroPorData = () => {

        ReceitaService.getFiltroPorData(dataInicial, dataFinal).then((response) => {
            setReceitas(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteReceitas = (receitaId) => {

        if (window.confirm("a despesa selecionada sera excluida"))
        {
       ReceitaService.deleteReceita(receitaId).then((response) =>{
        getAllReceitas();

       }).catch(error =>{
           console.log(error);
       })
       alert("receita excluida")
    }
        
    }

    return (
        <div className='container' id='container-receita'>
            <h2 className = "text-center"> Lista de Receitas </h2>

            <form id='filtroTipo'>
            <input type="text " id='tipoFiltro' placeholder='tipo de receita' onChange={(e) => setTipoReceita(e.target.value)} />
            <input type="button" value="filtrar" onClick={() => getFiltroPorTipo()} />
            </form>

            <form id='filtroData'>

            <label>data inicial</label>
            <input type="date" id='dataInicial' placeholder='data incicial' onChange={(e) => setDataInicial(e.target.value)} />
            <label>data final</label>
            <input type="date" id='dataFinal' placeholder='data final' onChange={(e) => setDataFinal(e.target.value)} />
            <input type="button" value="filtrar" onClick={() => getFiltroPorData()} />

            </form>
               <br/><br/>
               
            <table className="table table-bordered table-striped" id='tableReceita'>
                <thead>
                    <th> nº da conta </th>
                    <th> valor </th>
                    <th> data recebimento </th>
                    <th> data recebimento esperado </th>
                    <th> descrição</th>
                    <th id='tipoReceita'> tipo </th>
                    <th> Ações </th>
                </thead>
                <tbody>
                    {
                        receitas.map(
                            receita =>
                            <tr key = {receita.id}>

                                <td>{receita.contaId}</td>
                                <td>R${receita.valor} </td>
                                <td>{receita.dataRecebimento}</td>
                                <td>{receita.dataRecebimentoEsperado}</td>
                                <td>{receita.descricao}</td>
                                <td>{receita.tipoReceita}</td>
                                <td>
                                <Link  className="btn btn-info" to={`/receitaUp/${receita.id}`} id='btn-receita-update' ><MdModeEditOutline /></Link>
                                <button className = "btn btn-danger" id='btn-receita-delete' onClick={() => deleteReceitas(receita.id)}
                                    style={{ marginLeft: "10px" }}
                                    ><AiFillDelete/> </button>
                                    </td>
                            </tr>
                        )
                    }
                </tbody>

            </table>
            
        </div>
    )
}
