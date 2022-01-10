import axios from 'axios'

const RECEITA_REST_API_URL = 'http://localhost:8080/receitas';

class ReceitaService{

    getAllReceitas(){
        return axios.get(RECEITA_REST_API_URL)
    }

    createReceita(receita, contaId){
        return axios.post(RECEITA_REST_API_URL + '/' + contaId, receita)
    }

    getReceita(receitaId){
        return axios.get(RECEITA_REST_API_URL + '/' + receitaId);
    }

    getFiltroPorTipo(tipoReceita){
        return axios.get(RECEITA_REST_API_URL + '/filtro/tipo?tipoReceita=' + tipoReceita )
    }

    getFiltroPorData(dataInicial, dataFinal){
        return axios.get(RECEITA_REST_API_URL + '/filtro/data?dataInicial=' + dataInicial + '&dataFinal=' + dataFinal)
    }

    getReceitaTotalPorConta(contaId){
        return axios.get(RECEITA_REST_API_URL + '/receita_total/' + contaId)
    }


    updateReceita(receitaId, receita){
        return axios.put(RECEITA_REST_API_URL + '/' +receitaId, receita);
    }

    deleteReceita(receitaId){
        return axios.delete(RECEITA_REST_API_URL + '/' + receitaId);
    }
}

export default new ReceitaService();