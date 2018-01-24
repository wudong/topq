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
        ChoiceBody choiceBody = ChoiceBody.getInstance(
                "Which is a reserved word in the Java programming language?",
                new Choice(0, "method", false ),
                new Choice(1, "native", true ),
                new Choice(2, "sublcasses", false ),
                new Choice(3, "reference", false ),
                new Choice(3, "volatile", true )
        );

        QuestionMeta questionMeta = QuestionMetaImpl.builder()
                .difficulity(0)
                .build();
        return ChoiceQuestion.builder().body(choiceBody).meta(questionMeta).build();
    }

    public static ChoiceQuestion sampleChoiceQuestion3() {
        ChoiceBody choiceBody = ChoiceBody.getInstance(
                "Which one of the following will declare an array and initialize it with five numbers?",
                new Choice(0, "Array a = new Array(5);", false ),
                new Choice(1, "int [] a = {23,22,21,20,19};", true ),
                new Choice(2, "int a [] = new int[5];", false ),
                new Choice(3, "int [5] array;", false )
        );

        QuestionMeta questionMeta = QuestionMetaImpl.builder()
                .explaination(
                        "Option B is the legal way to declare and initialize an array with five elements.\n" +
                        "Option A is wrong because it shows an example of instantiating a class named Array, passing the integer value 5 to the object's constructor. If you don't see the brackets, you can be certain there is no actual array object! In other words, an Array object (instance of class Array) is not the same as an array object.\n" +
                        "Option C is wrong because it shows a legal array declaration, but with no initialization.\n" +
                        "Option D is wrong (and will not compile) because it declares an array with a size. Arrays must never be given a size when declared.")
                .difficulity(0)
                .build();
        return ChoiceQuestion.builder().body(choiceBody).meta(questionMeta).build();
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
