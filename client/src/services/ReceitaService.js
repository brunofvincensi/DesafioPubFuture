import axios from 'axios'

const RECEITA_REST_API_URL = 'http://localhost:8080/receitas';

class ReceitaService{

    getAllReceitas(){
        return axios.get(RECEITA_REST_API_URL)
    }

    createReceita(receita){
        return axios.post(RECEITA_REST_API_URL, receita)
    }

    getEmployeeById(receitaId){
        return axios.get(RECEITA_REST_API_URL + '/' + receitaId);
    }

    updateEmployee(receitaId, receita){
        return axios.put(RECEITA_REST_API_URL + '/' +receitaId, receita);
    }

    deleteEmployee(receitaId){
        return axios.delete(RECEITA_REST_API_URL + '/' + receitaId);
    }
}

export default new ReceitaService();