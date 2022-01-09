import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import ReceitaService from '../../../services/ReceitaService'
import "./style.css"
import { MdModeEditOutline } from "react-icons/md";
import { AiFillDelete } from "react-icons/ai";


 export function Receitas () {

    const [receitas, setReceitas] = useState([])
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

    const deleteReceitas = (receitaId) => {
       ReceitaService.deleteReceita(receitaId).then((response) =>{
        getAllReceitas();

       }).catch(error =>{
           console.log(error);
       })
        
    }

    return (
        <div className='container' id='container-receita'>
            <h2 className = "text-center"> Lista de Receitas </h2>

            <input type="text " id='filtroTipo' placeholder='tipo de receita' onChange={(e) => setTipoReceita(e.target.value)}/>
               <input type="button" value="filtrar" onClick={() => getFiltroPorTipo()}/>
               <br/><br/>
               
            <table className="table table-bordered table-striped" id='tableReceita'>
                <thead>
                    
                    <th> valor </th>
                    <th> data recebimento </th>
                    <th> data recebimento esperado </th>
                    <th> descricao</th>
                    <th id='tipoReceita'> tipo </th>
                    <th> Ações </th>
                </thead>
                <tbody>
                    {
                        receitas.map(
                            receita =>
                            <tr key = {receita.id}> 
                                
                                <td> {receita.valor} </td>
                                <td>{receita.dataRecebimento}</td>
                                <td>{receita.dataRecebimentoEsperado}</td>
                                <td>{receita.descricao}</td>
                                <td>{receita.tipoReceita}</td>

                                <td>
                                <Link  className="btn btn-info" to={`/receitaUp/${receita.id}`} id='receitaUpdate' ><MdModeEditOutline /></Link>
                                <button className = "btn btn-danger" id='btn_receita_delete' onClick={() => deleteReceitas(receita.id)}
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
