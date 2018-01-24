import axios from 'axios';

interface DAO {
    getQuestionById(id: string): Promise<Question>;
    searchQuestionByTag(tag: Tag): Promise<Question[]>;
}

class DaoImpl implements DAO {

    private baseUrl: string;

    constructor(baseUrl: string){
        this.baseUrl = baseUrl;
    }

    getQuestionById(id: string): Promise<Question> {
        const request =`${this.baseUrl}/questions/${id}`;
        return axios.get(request);
    }

    searchQuestionByTag(tag: Tag): Promise<Question[]> {
        return undefined;
    }
}

export function getDaoInstance(baseUrl: string): DAO {
    return new DaoImpl(baseUrl);
}