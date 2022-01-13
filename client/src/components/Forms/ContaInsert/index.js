import React, {useState} from 'react'
import {Link, useNavigate } from 'react-router-dom';
import ContaService from '../../../services/ContaService';

const ContaInsert = () => {

    const [tipoConta, setTipoConta] = useState('')
    const [instituicao, setInstituicao] = useState('')
    const history = useNavigate();


    const saveConta = (e) => {
        e.preventDefault();

        const conta = {tipoConta, instituicao}

    
        if(tipoConta != null && tipoConta !== '' && instituicao != null && instituicao !== ''){

            ContaService.createConta(conta).then((response) =>{

                console.log(response.data)
    
                history.push('/');
    
            }).catch(error => {
                console.log(error)
            })
            alert("conta inserida")
        }
        else{
            alert("preencha os campos requeridos")
        }
        }
        
    


  return (
        <div className="despesaUp" onClick={e => e.stopPropagation()}>
            <div>

                <form id="form">

                <Link id="voltar" to={ "/"}><button>voltar</button></Link>
                   <p id="title" >Adicionar Conta</p>
                                    
                  <br/><br/>
                   
                    <select id="dataPagamento" name="dataPagamento" onChange={(e) => setTipoConta(e.target.value)}>
                        <option value="CARTEIRA" key="">carteira</option>
                        <option value="CONTA_CORRENTE" key="">conta corrente</option>
                        <option value="POUPANCA" key="">poupança</option>
                    </select>
                    <br/><br/>

                    <input
                        type="text"
                        name="dataPagamentoEsperado"
                        id="dataPagamentoEsperado"
                        placeholder='* instituição'
                
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