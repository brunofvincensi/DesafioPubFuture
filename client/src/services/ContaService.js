import axios from 'axios'

const CONTAS_REST_API_URL = 'http://localhost:8080/conta';

class ContaService{

    getAllContas(){
        return axios.get(CONTAS_REST_API_URL)
    }

    
}

export default new ContaService();