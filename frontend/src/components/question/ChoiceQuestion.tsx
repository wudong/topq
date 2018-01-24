import * as React from 'react';
import './Question.css';
import FontAwesome = require('react-fontawesome');
import {ChoiceQuestion, Choice, isMultiChoiceQuestion, ChoiceBody} from '../../model/ChoiceQuestion';


interface ChoiceProps {
    choice: Choice;
    multi: boolean;
    selected: boolean;
    isWrong: boolean;
    showCorrectness: boolean;
    clickListener: (choice: Choice) => void;
}

class ChoiceComponent extends React.Component<ChoiceProps> {

    constructor() {
        super();
    }

    render() {
        const symbol = this.getChoiceSymbol(this.props.multi, this.props.selected);

        return (
            <div className={`choice ${this.getCorrectnessClass()}`} onClick={this.onClicked}>

                <div className="choiceSymbol">
                    <FontAwesome name={symbol}/>
                </div>

                {this.getCorrectnessComponent()}

                <div className="choiceIndex">
                    {indexCharacterMap(this.props.choice.index)}
                </div>

                <div className="choiceText">{this.props.choice.text}</div>
            </div>
        );
    }

    private getCorrectnessComponent() {
        if (this.props.showCorrectness && this.props.selected) {
            const symbol = this.getCorrectnessSymbol(!this.props.isWrong);
            return (
                <div>
                    <FontAwesome name={symbol}/>
                </div>
            );
        } else return null;
    }

    private getCorrectnessClass() {
        if (this.props.showCorrectness && this.props.isWrong) {
            return 'wrong-answer';
        } else {
            return '';
        }
    }

    private onClicked = () => {
        //send event to upper component
        this.props.clickListener(this.props.choice);
    }


    private getCorrectnessSymbol(correct: boolean): string {
        return correct? 'check': 'times';
    }

    private getChoiceSymbol(multi: boolean, selected: boolean): string {
        if (multi) {
            return selected ? 'check-square' : 'square';
        } else {
            return selected ? 'dot-circle' : 'circle';
        }
    }

}

function indexCharacterMap(index: number): string {
    // 65 is the ASCII value for character 'A'
    let ASCII_CHAR_A = 65;
    return String.fromCharCode(ASCII_CHAR_A + index);
}

interface ChoiceQuestionProps {
    question:ChoiceQuestion;
}

interface ChoiceQuestionState {
    selection: { [key: number]: boolean };
}

class ChoiceQuestionComponent extends React.Component<ChoiceQuestionProps, ChoiceQuestionState> {

    private body: ChoiceBody;
    private isMultiChoice: boolean;

    constructor(props: ChoiceQuestionProps) {
        super();

        this.body = props.question.body;
        this.isMultiChoice = isMultiChoiceQuestion(this.body);

        this.state = {
            selection: this.initSelection()
        };
    }

    private initSelection() {
        return this.body.choices.map(
            (cc) => {
                let idx = cc.index;
                return {
                    [idx]: false
                };
            }
        ).reduce((accumulator, currentValue)=>({...accumulator, ...currentValue}), {});
    }

    render() {
        return (
            <div className="choices">
                <div className="bodyText">{this.body.text}</div>
                {
                    this.body.choices.map(cc =>
                        (<ChoiceComponent key={cc.index}
                                          choice={cc}
                                          multi={this.isMultiChoice}
                                          selected={this.isSelected(cc)}
                                          clickListener={this.choiceClicked}
                                          isWrong={this.isWronglyAnsweredChoice(cc)}
                                          showCorrectness={true}
                        /> ))
                }
            </div>
        );
    }

    private isSelected(choice: Choice): boolean {
        return this.state.selection[choice.index];
    }

    private choiceClicked = (choice: Choice) => {
        this.setState(this.stateReducer(choice));
    }

    private stateReducer(choice: Choice):
    (state: ChoiceQuestionState, props: ChoiceQuestionProps)=>ChoiceQuestionState {
        return (prevState: ChoiceQuestionState, props: ChoiceQuestionProps) => {
            let curIndex =choice.index;
            let prevSelection = prevState.selection;
            if (this.isMultiChoice) {
                return {selection: {...prevSelection, [curIndex]: !prevSelection[curIndex] }};
            } else {
                return {selection: {...this.initSelection(), [curIndex]: true }};
            }
        };
    }

    private isWronglyAnsweredChoice(choice: Choice) {
        let selected = this.isSelected(choice);
        return (selected && !choice.isCorrect) || (!selected && choice.isCorrect);
    }

    public isQuestionAnsweredCorrectly(): boolean {
        return this.body.choices.every((c)=> !this.isWronglyAnsweredChoice(c));
    }

}

export default ChoiceQuestionComponent;
