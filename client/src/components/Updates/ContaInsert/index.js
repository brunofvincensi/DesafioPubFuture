import React, {useState} from 'react'
import {Link, useNavigate } from 'react-router-dom';
import ContaService from '../../../services/ContaService';

const ContaInsert = () => {
    const [saldo, setSaldo] = useState('')
    const [tipoConta, setTipoConta] = useState('')
    const [instituicao, setInstituicao] = useState('')
    const history = useNavigate();


    const saveConta = (e) => {
        e.preventDefault();

        const conta = {saldo, tipoConta, instituicao}

            ContaService.createConta(conta).then((response) =>{

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

                <Link id="voltar" to={ "/"}><button>voltar</button></Link>
                   <p id="title" >Adicionar Conta</p>
                   
               
                    <input
                        type="number"
                        name="valorDespesa"
                        id="valorDespesa"
                        placeholder='saldo'
              
                        onChange={(e) => setSaldo(e.target.value)}
                        
                        
                    /> 

                  <br/><br/>
                   
                    <input
                        type="text"
                        name="dataPagamento"
                        id="dataPagamento"
                        placeholder='tipo da conta'
                        
                        
                        onChange={(e) => setTipoConta(e.target.value)}
                    />
                    <br/><br/>

                    <input
                        type="text"
                        name="dataPagamentoEsperado"
                        id="dataPagamentoEsperado"
                        placeholder='instituição'
                
                        onChange={(e) => setInstituicao(e.target.value)}
                    />                    

                     <br/><br/>

                    
                            <input
                            type="button"
                            id="button-alterar-despesa"
                            title="Update Conta"
                            value="Confirm"
                            onClick={(e) => saveConta(e)}
                        >
                             
                        </input>
                                                           
                        <br/><br/>

                </form>
           
            </div>
           
        </div>
    );
  
  }

export default ContaInsert;