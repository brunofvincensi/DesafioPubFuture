import "./style.css";
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import DespesaService from "../../../services/DespesaService";

const DespesaUp = () => {
    const [valor, setValor] = useState("");
    const [dataPagamento, setDataPagamento] = useState("");
    const [dataPagamentoEsperado, setDataPagamentoEsperado] = useState("");
    const [tipoDespesa, setTipoDespesa] = useState("")
    const { id } = useParams();


    const history = useNavigate();

    useEffect(() => {

        DespesaService.getDespesa(id).then((response) => {
            setValor(response.data.valor)
            setDataPagamento(response.data.dataPagamento)
            setDataPagamentoEsperado(response.data.dataPagamentoEsperado)
            setTipoDespesa(response.data.tipoDespesa)
        }).catch(error => {
            console.log(error)
        })
    }, [])




    const UpdateDespesa = (e) => {
        e.preventDefault();

        if (window.confirm("a despesa será alterada")) {

            const despesa = { valor, dataPagamento, dataPagamentoEsperado, tipoDespesa }

            if(valor != null && valor !== '' && dataPagamento != null && dataPagamento !== '' && tipoDespesa != null && tipoDespesa !== ''){

            DespesaService.updateDespesa(id, despesa).then((response) => {
                history.push("/despesas")
            }).catch(error => {
                console.log(error)
            })
            alert("despesa alterada")}
            else{
                alert("preencha os campos requeridos")
            }
        }


    }





    return (
        <div className="despesaUp" onClick={e => e.stopPropagation()}>
            <div>

                <form id="form">

                    <Link id="voltar" to={"/despesas"}><button>voltar</button></Link>
                    <p id="title" >Alterar Despesa</p>


                    <input
                        type="number"
                        name="valorDespesa"
                        id="valorDespesa"
                        placeholder="* valor"
                        value={parseFloat(valor)}
                        onChange={(e) => setValor(e.target.value)}


                    />

                    <br /><br />


                    <input
                        type="date"
                        name="dataPagamento"
                        id="dataPagamento"
                        placeholder="* data do pagamento"
                        value={dataPagamento}

                        onChange={(e) => setDataPagamento(e.target.value)}
                    />
                    <br /><br />

                    <input
                        type="date"
                        name="dataPagamentoEsperado"
                        id="dataPagamentoEsperado"
                        placeholder="data do pagamento esperada"
                        value={dataPagamentoEsperado}
                        onChange={(e) => setDataPagamentoEsperado(e.target.value)}
                    />

                    <br /><br />

                    <input
                        type="text"
                        name="tipoDespesa"
                        id="tipoDespesa"
                        placeholder="* tipo da despesa"
                        value={tipoDespesa}
                        onChange={(e) => setTipoDespesa(e.target.value)}
                    />

                    <br /><br />


                    <input
                        type="button"
                        id="button-alterar-despesa"
                        title="Update Conta"
                        value="Confirm"
                        onClick={(e) => UpdateDespesa(e)}
                    >

                    </input>

                    <br /><br />

                </form>

            </div>

        </div>
    );

}

export default DespesaUp;