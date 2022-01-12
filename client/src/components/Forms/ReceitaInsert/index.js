import React, {useState} from 'react'
import {Link, useNavigate, useParams } from 'react-router-dom';
import ReceitaService from '../../../services/ReceitaService';

const DespesaInsert = () =>{

    const [valor, setValor] = useState("");
    const [dataRecebimento, setDataRecebimento] = useState("");
    const [dataRecebimentoEsperado, setDataRecebimentoEsperado] = useState("");
    const [descricao, setDescricao] = useState("");
    const [tipoReceita, setTipoReceita] = useState("");
    const { id } = useParams();
    const history = useNavigate();

    const saveReceita = (e) => {
        e.preventDefault();

        const receita = {valor, dataRecebimento, dataRecebimentoEsperado, descricao, tipoReceita}

        if(valor != null && valor !== '' && dataRecebimento != null && dataRecebimento !== '' && tipoReceita != null && tipoReceita !== ''){

            ReceitaService.createReceita(receita, id).then((response) =>{

                console.log(response.data)
    
                history.push('/');
    
            }).catch(error => {
                console.log(error)
            })
            alert("receita inserida")}
            else{
                alert("preencha os campos requeridos")
            }
        }

        return (
            <div className="despesaUp" onClick={e => e.stopPropagation()}>
                <div>
                                   
    
                    <form id="form">
    
                    <Link id="voltar" to={ `/conta/${id}`}><button>voltar</button></Link>
                       <p id="title" >Adicionar Receita</p>
                                         
                        <input
                            type="number"
                            name="valorReceita"
                            id="valorReceita"
                            placeholder='* valor'
                            onChange={(e) => setValor(e.target.value)}                            
                            
                        /> 
    
                      <br/><br/>
                           
                        <input
                            type="date"
                            name="dataRecebimento"
                            id="dataRecebimento"
                            placeholder='* data do recebimento'
                            onChange={(e) => setDataRecebimento(e.target.value)}
                        />
                        <br/><br/>
    
                        <input
                            type="date"
                            name="dataRecebimentoEsperado"
                            id="dataRecebimentoEsperado"
                            placeholder='data do recebimento esperado'
                            onChange={(e) => setDataRecebimentoEsperado(e.target.value)}
                        />
    
                         <br/><br/>

                         <input
                            type="text"
                            name="descricao"
                            id="descricao"
                            placeholder='descrição da receita'
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
                                id="button-alterar-despesa"
                                title="gerar receita"
                                value="Confirmar"
                                onClick={(e) => saveReceita(e)}
                            >
                                 
                            </input>
                                               
                      
                            <br/><br/>
    
                           
               
                    </form>
               
                </div>
               
            </div>
        );






}

export default DespesaInsert