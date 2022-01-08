import "./style.css";
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import ContaService from "../../../services/ContaService";

const ContUp = () => {
    const [saldo, setSaldo] = useState("");
    const [tipoConta, setTipoConta] = useState("");
    const [instituicao, setInstituicao] = useState("");
    const { id } = useParams();


    const history = useNavigate();

    useEffect(() => {

        ContaService.getConta(id).then((response) =>{
            setSaldo(response.data.saldo)
            setTipoConta(response.data.tipoConta)
            setInstituicao(response.data.instituicao)
        }).catch(error => {
            console.log(error)
        })
    }, [])




    const UpdateOrAddConta = (e) => {
        e.preventDefault();

        const conta = { saldo, tipoConta, instituicao }


        if(id){
        ContaService.updateConta(id, conta).then((response) => {
            history.push("/contas")
        }).catch(error => {
            console.log(error)
        })}
        else{ContaService.createConta(conta).then((response) =>{

            console.log(response.data)

            history.push('/');

        }).catch(error => {
            console.log(error)
        })


        }

        
    }

   function title(){

 if(id){
       return "Alterar Conta"}

       else{
           return "Adicionar Conta"
       }
    

   }


    

    return (
        <div className="contaUp" id="screenContaUp" onClick={e => e.stopPropagation()}>
            <div className="contaForm">
               
           
            

                <form id="form">

                <Link id="voltar" to={"/"}><button>voltar</button></Link>
                   <p id="title" >{title()}</p>
                   
               
                    <input
                        type="number"
                        name="saldoConta"
                        id="saldoConta"
                        value={saldo}
                        onChange={(e) => setSaldo(e.target.value)}
                        
                        
                    /> 

                  <br/><br/>

                   
                    <input
                        type="text"
                        name="instituicaoConta"
                        id="instituicaoConta"
                        value={instituicao}
                        
                        onChange={(e) => setInstituicao(e.target.value)}
                    />
                    <br/><br/>

                    <input
                        type="text"
                        name="tipoConta"
                        id="tipoCont"
                        value={tipoConta}
                        onChange={(e) => setTipoConta(e.target.value)}
                    />

                     <br/><br/>

                    
                       
                   
                            <input
                            type="button"
                            id="buttonConfirmConta"
                            title="Update Conta"
                            value="Confirm"
                            onClick={(e) => UpdateOrAddConta(e)}
                        >
                             
                        </input>
                      
                        

                         
                  
                        <br/><br/>

                       
           
                </form>
           
            </div>
           
        </div>
    );
}



export default ContUp;