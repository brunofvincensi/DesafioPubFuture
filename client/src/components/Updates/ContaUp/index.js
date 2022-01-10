import "./style.css";
import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import ContaService from "../../../services/ContaService";
import ReceitaUp from "../ReceitaUp"
import DespesaUp from "../DespesaUp"
import DespesaService from "../../../services/DespesaService";
import ReceitaService from "../../../services/ReceitaService";

const ContUp = () => {
    const [saldo, setSaldo] = useState("");
    const [tipoConta, setTipoConta] = useState("");
    const [instituicao, setInstituicao] = useState("");
    const { id } = useParams();

    const [id2, setId2] = useState("");
    const [valor, setValor] = useState("");

    const [despesaTotal, setDespesaTotal] = useState()
    const [receitaTotal, setReceitaTotal] = useState()






    const history = useNavigate();





    useEffect(() => {

        ContaService.getConta(id).then((response) => {
            setSaldo(response.data.saldo)
            setTipoConta(response.data.tipoConta)
            setInstituicao(response.data.instituicao)
        }).catch(error => {
            console.log(error)
        })



    }, [])

    useEffect(() => {

        DespesaService.getDespesaTotalPorConta(id).then((response) => {
            setDespesaTotal(response.data)
        }).catch(error => {
            console.log(error)
        })

    }, [])

    useEffect(() => {

        ReceitaService.getReceitaTotalPorConta(id).then((response) => {
            setReceitaTotal(response.data)
        }).catch(error => {
            console.log(error)
        })

    }, [])

    const UpdateConta = (e) => {
        e.preventDefault();

        const conta = { saldo, tipoConta, instituicao }

        ContaService.updateConta(id, conta).then((response) => {
            history.push("/contas")
        }).catch(error => {
            console.log(error)
        })


    }

    const TransferirSaldo = (e) => {
        e.preventDefault();

        console.log(parseInt(id))
        console.log(parseInt(id2))
        console.log(parseFloat(valor))

        ContaService.transefirSaldo(id, parseInt(id2), parseFloat(valor)).then((response) => {
            history.push("/contas")

        }).catch(error => {
            console.log(error)
        })


    }



    function title() {

        if (id) {
            return "Alterar Conta"
        }

        else {
            return "Adicionar Conta"
        }


    }

    let i = "R$ " + saldo;




    return (
        <div className="contaUp" id="screenContaUp" onClick={e => e.stopPropagation()}>
            <div className="contaForm">




                <form id="form">


                    <br /><br /><br />
                    <p id="infConta" >Informações da conta</p>
                    <br />

                    <label id='label-saldo'>
                        saldo
                    </label>

                    <input
                        type="text"
                        name="saldoConta"
                        id="saldoConta"
                        value={i}
                        readOnly
                        onChange={(e) => setSaldo(e.target.value)}


                    />

                    <label id="label-instituicao">
                        instituição
                    </label>


                    <input
                        type="text"
                        name="instituicaoConta"
                        id="instituicaoConta"
                        value={instituicao}

                        onChange={(e) => setInstituicao(e.target.value)}
                    />
                    <br />
                    <br />

                    <label id="label-tipoConta">tipo da conta</label>

                    <input
                        type="text"
                        name="tipoConta"
                        id="tipoCont"
                        value={tipoConta}
                        onChange={(e) => setTipoConta(e.target.value)}
                    />

                    <br /><br />

                    <input
                        type="button"
                        id="buttonConfirmConta"
                        title="Update Conta"
                        value={title()}
                        onClick={(e) => UpdateConta(e)}
                    >

                    </input>

                    <div class="linha-vertical"></div>


                    <div id="transferir-saldo">

                        <div id='titulo_transferencia'>Transferência de saldo</div>

                        <form>

                            <input type="text" id="id2" placeholder="nº da conta" onChange={(e) => setId2(e.target.value)} />

                            <input type="text" id="saldoTransferido" placeholder="valor" onChange={(e) => setValor(e.target.value)} />

                            <input type="button" value="tranferir" onClick={(e) => TransferirSaldo(e)} >

                            </input>
                        </form>



                    </div>

                    <div id="despesa-box">

                        <Link to={`/contaUp/${id}/add-despesa`} >
                            <input type="button"

                                id="adicionarDespesa"
                                value="adicionar despesa"
                                title="Adicionar uma Despesa"
                            />
                        </Link>

                        <br /><br />
                        <div> <b>R${despesaTotal}</b></div>

                    </div>

                    <div id="receita-box">

                        <Link to={`/contaUp/${id}/add-receita`}>
                            <input type="button"
                                id="adicionarReceita"
                                value="adicionar receita"
                                title="Adicionar uma Receita"

                            />
                        </Link>
                        <br /><br />
                        <div> <b>R${receitaTotal}</b></div>

                    </div>





                    <br /><br />



                </form>

            </div>



        </div>
    );
}



export default ContUp;