package uk.graceliu.topq.util;

import uk.graceliu.topq.model.QuestionMeta;
import uk.graceliu.topq.model.choice.Choice;
import uk.graceliu.topq.model.choice.ChoiceBody;
import uk.graceliu.topq.model.choice.ChoiceQuestion;
import uk.graceliu.topq.model.impl.QuestionMetaImpl;
import uk.graceliu.topq.model.input.InputQuestion;

public class SampleQuestions {

    public static ChoiceQuestion sampleChoiceQuestion1() {
        ChoiceBody choiceBody = ChoiceBody.getInstance(
                "Which will legally declare, construct, and initialize an array?",
                new Choice(0, "int [] myList = {\"1\", \"2\", \"3\"};", false ),
                new Choice(1, "int [] myList = (5, 8, 2);", false ),
                new Choice(2, "int myList [] [] = {4,9,7,0};", false ),
                new Choice(3, "int myList [] = {4, 3, 7};", true )
           );

        QuestionMeta questionMeta = QuestionMetaImpl.builder()
                .explaination(
                        "The only legal array declaration and assignment statement is Option D\n" +
                        "Option A is wrong because it initializes an int array with String literals.\n" +
                        "Option B is wrong because it use something other than curly braces for the initialization.\n" +
                        "Option C is wrong because it provides initial values for only one dimension, although the declared array is a two-dimensional array.")
                .difficulity(0)
                .build();
        return ChoiceQuestion.builder().body(choiceBody).meta(questionMeta).build();
    }

    public static ChoiceQuestion sampleChoiceQuestion2() {
        return null;
    }

    public static ChoiceQuestion sampleChoiceQuestion3() {
        return null;
    }

    public static InputQuestion sampleInputQuestion1() {
        return null;
    }

    public static InputQuestion sampleInputQuestion2() {
        return null;
    }

    public static InputQuestion sampleInputQuestion3() {
        return null;
    }

}
