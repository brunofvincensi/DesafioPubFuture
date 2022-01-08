import axios from 'axios'

const DESPESA_REST_API_URL = 'http://localhost:8080/despesas';

class DespesaService{

    getAllDespesas(){
        return axios.get(DESPESA_REST_API_URL)
    }

    createDespesa(despesa){
        return axios.post(DESPESA_REST_API_URL, despesa)
    }

    getDespesa(despesaId){
        return axios.get(DESPESA_REST_API_URL + '/' + despesaId)
    }


    updateDespesa(despesaId, despesa){
        return axios.put(DESPESA_REST_API_URL + '/' +despesaId, despesa);
    }

    deleteDespesa(despesaId){
        return axios.delete(DESPESA_REST_API_URL + '/' + despesaId);
    }
}

export default new DespesaService();