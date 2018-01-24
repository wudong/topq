import * as React from 'react';
import * as ReactDOM from 'react-dom';


import ChoiceQuestionComponent from './components/question/ChoiceQuestion';
import { ChoiceQuestion } from './model/ChoiceQuestion';

let BACKEND_URL = 'http://localhost:8081/api/questions';



function render(qs: ChoiceQuestion[]) {

    let anies = (
        <div>
            {qs.map((q,idx)=> (<ChoiceQuestionComponent question={q} key={idx}/>) )}
        </div>
    );

    ReactDOM.render(anies,
        document.getElementById('root') as HTMLElement
    );
}
