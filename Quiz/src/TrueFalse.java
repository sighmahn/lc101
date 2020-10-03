public class TrueFalse extends Question{

    private boolean correctAnswer;

    public TrueFalse(String prompt, Boolean correctAnswer) {
        super(prompt);
        this.options.add("True");
        this.options.add("False");
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String answer) {
        int answerNumber = Integer.parseInt(answer);
        String givenAnswer = options.get(answerNumber -1);
        return givenAnswer.toLowerCase().equals("true") == correctAnswer;
    }
}
