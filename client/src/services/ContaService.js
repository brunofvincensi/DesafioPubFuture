import axios from 'axios'

const CONTAS_REST_API_URL = 'http://localhost:8080/conta';

class ContaService{

    getAllContas(){
        return axios.get(CONTAS_REST_API_URL)
    }

    getSaldoTotal(){
        return axios.get(CONTAS_REST_API_URL + '/saldo_total')
    }

    deleteConta(contaId){
        return axios.delete(CONTAS_REST_API_URL + '/' + contaId)
    }

    updateConta(contaId, conta){
        return axios.put(CONTAS_REST_API_URL + '/' +contaId, conta);
    }

    getConta(contaId){
        return axios.get(CONTAS_REST_API_URL + '/' + contaId)
    }

    createConta(conta){
        return axios.post(CONTAS_REST_API_URL, conta)
    }

    transefirSaldo(id1, id2, valor){

    return axios.patch(CONTAS_REST_API_URL + '/transferir_saldo?id1=' + id1 + '&id2=' + id2 + '&valor=' + valor);

    }

    
}

export default new ContaService();