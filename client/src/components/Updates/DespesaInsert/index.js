import React, {useState} from 'react'
import {Link, useNavigate, useParams } from 'react-router-dom';
import ContaService from '../../../services/ContaService';
import DespesaService from '../../../services/DespesaService';

const DespesaInsert = () =>{

    const [valor, setValor] = useState("");
    const [dataPagamento, setDataPagamento] = useState("");
    const [dataPagamentoEsperado, setDataPagamentoEsperado] = useState("");
    const [tipoDespesa, setTipoDespesa] = useState("")
    const { id } = useParams();
    const history = useNavigate();

    const saveDespesa = (e) => {
        e.preventDefault();

        const despesa = {valor, dataPagamento, dataPagamentoEsperado, tipoDespesa}

            DespesaService.createDespesa(despesa, id).then((response) =>{

                console.log(response.data)
    
                history.push('/');
    
            }).catch(error => {
                console.log(error)
            })
        }

        return (
            <div className="despesaUp" onClick={e => e.stopPropagation()}>
                <div>
                   
               
                
    
                    <form id="form">
    
                    <Link id="voltar" to={ `/conta/${id}`}><button>voltar</button></Link>
                       <p id="title" >Adicionar Despesa</p>
                                         
                        <input
                            type="number"
                            name="valorDespesa"
                            id="valorDespesa"
                            placeholder='valor'
                            onChange={(e) => setValor(e.target.value)}                            
                            
                        /> 
    
                      <br/><br/>
                           
                        <input
                            type="date"
                            name="dataPagamento"
                            id="dataPagamento"
                            placeholder='data pagamento'
                            onChange={(e) => setDataPagamento(e.target.value)}
                        />
                        <br/><br/>
    
                        <input
                            type="date"
                            name="dataPagamentoEsperado"
                            id="dataPagamentoEsperado"
                            placeholder='data pagamento esperada'
                            onChange={(e) => setDataPagamentoEsperado(e.target.value)}
                        />
    
                         <br/><br/>
    
                         <input
                            type="text"
                            name="tipoDespesa"
                            id="tipoDespesa"
                            placeholder='tipo da despesa'
                            onChange={(e) => setTipoDespesa(e.target.value)}
                        />
    
                         <br/><br/>
    
                        
                                <input
                                type="button"
                                id="button-alterar-despesa"
                                title="gerar despesa"
                                value="Confirmar"
                                onClick={(e) => saveDespesa(e)}
                            >
                                 
                            </input>
                                               
                      
                            <br/><br/>
    
                           
               
                    </form>
               
                </div>
               
            </div>
        );






}

export default DespesaInsert