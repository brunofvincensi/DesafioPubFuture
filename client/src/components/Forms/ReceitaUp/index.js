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

            if(valor != null && valor !== '' && dataRecebimento != null && dataRecebimento !== '' && tipoReceita != null && tipoReceita !== ''){

        const receita = { valor, dataRecebimento, dataRecebimentoEsperado, descricao, tipoReceita }

            ReceitaService.updateReceita(id, receita).then((response) => {
            history.push("/receitas")
        }).catch(error => {
            console.log(error)
        })
        alert("receita alterada")}
        else{
            alert("preencha os campos requeridos")
        }
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
                        placeholder="* valor"
                        value={parseFloat(valor)}
                        onChange={(e) => setValor(e.target.value)}
                                               
                    /> 

                  <br/><br/>

                   
                    <input
                        type="date"
                        name="dataRecebimento"
                        id="dataRecebimento"
                        placeholder="* data do recebimento"
                        value={dataRecebimento}                      
                        onChange={(e) => setDataRecebiento(e.target.value)}
                    />
                    <br/><br/>

                    <input
                        type="date"
                        name="dataRecebimentoEsperado"
                        id="dataRecebimentoEsperado"
                        placeholder="data do recebimento esperada"
                        value={dataRecebimentoEsperado}
                        onChange={(e) => setDataRecebimentoEsperado(e.target.value)}
                    />

                     <br/><br/>

                     <input
                        type="text"
                        name="descricao"
                        id="descricao"
                        placeholder="descrição"
                        value={descricao}
                        onChange={(e) => setDescricao(e.target.value)}
                    />

                     <br/><br/>



                     <select value={tipoReceita} onChange={(e) => setTipoReceita(e.target.value)}>
                             <option value="SALARIO">salário</option>
                             <option value="PRESENTE" >presente</option>
                             <option value="PREMIO">prêmio</option>
                             <option value="OUTROS" >outros</option>
                       
                         </select>

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