export class ChoiceQuestion implements Question {
    body: ChoiceBody;
    meta: QuestionMeta;
}

export class ChoiceBody {
    text: string;
    choices: Choice[]
}

export function isMultiChoiceQuestion(body: ChoiceBody) : boolean {
    return body.choices.filter(c=>c.isCorrect).length > 1;
}

export class Choice {
    index: number;
    text: string;
    isCorrect: boolean;
}
