import "./style.css";
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import ReceitaService from "../../../services/ReceitaService";

const ReceitaUp = () => {
    const [valor, setValor] = useState("");
    const [dataRecebimento, setDataRecebiento] = useState("");
    const [dataRecebimentoEsperado, setDataRecebimentoEsperado] = useState("");
    const [descricao, setDescricao] = useState("");
    const [tipoReceita, setTipoReceita] = useState("")
    const { id } = useParams();


    const history = useNavigate();

    useEffect(() => {

        ReceitaService.getReceita(id).then((response) =>{
            setValor(response.data.valor)
            setDataRecebiento(response.data.dataRecebimento)
            setDataRecebimentoEsperado(response.data.dataRecebimentoEsperado)
            setDescricao(response.data.descricao)
            setTipoReceita(response.data.tipoReceita)
        }).catch(error => {
            console.log(error)
        })
    }, [])




    const UpdateReceita = (e) => {
        e.preventDefault();

        if(window.confirm("a receita será alterada")){

        const receita = { valor, dataRecebimento, dataRecebimentoEsperado, descricao, tipoReceita }

            ReceitaService.updateReceita(id, receita).then((response) => {
            history.push("/receitas")
        }).catch(error => {
            console.log(error)
        })
        alert("receita alterada")
    }

    
        }

        



  return (
        <div className="receitaUp" id="screenReceitaUp" onClick={e => e.stopPropagation()}>
            <div>
               
                <form id="form">

                <Link id="voltar" to={"/receitas"}><button>voltar</button></Link>
                   <p id="title" >Alterar Despesa</p>
                   
               
                    <input
                        type="number"
                        name="valorReceita"
                        id="valorReceita"
                        value={parseFloat(valor)}
                        onChange={(e) => setValor(e.target.value)}
                        
                        
                    /> 

                  <br/><br/>

                   
                    <input
                        type="date"
                        name="dataRecebimento"
                        id="dataRecebimento"
                        value={dataRecebimento}
                        
                        onChange={(e) => setDataRecebiento(e.target.value)}
                    />
                    <br/><br/>

                    <input
                        type="date"
                        name="dataRecebimentoEsperado"
                        id="dataRecebimentoEsperado"
                        value={dataRecebimentoEsperado}
                        onChange={(e) => setDataRecebimentoEsperado(e.target.value)}
                    />

                     <br/><br/>

                     <input
                        type="text"
                        name="descricao"
                        id="descricao"
                        value={descricao}
                        onChange={(e) => setDescricao(e.target.value)}
                    />

                     <br/><br/>



                     <input
                        type="text"
                        name="tipoReceita"
                        id="tipoReceita"
                        value={tipoReceita}
                        onChange={(e) => setTipoReceita(e.target.value)}
                    />

                     <br/><br/>

                    
                            <input
                            type="button"
                            id="button-alterar-receita"
                            title="Update Conta"
                            value="Confirm"
                            onClick={(e) => UpdateReceita(e)}
                        >
                             
                        </input>
                      
                        

                         
                  
                        <br/><br/>

                       
           
                </form>
           
            </div>
           
        </div>
    );
  
  }

export default ReceitaUp;