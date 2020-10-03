public class MultipleChoice extends Question{

    private String correctAnswer;

    public MultipleChoice(String prompt, String correctAnswer) {
        super(prompt);
        this.correctAnswer = correctAnswer;
    }

    public void addOption(String option) {
        options.add(option);
    }
    @Override
    public boolean isCorrect(String answer) {
        int answerOption = Integer.parseInt(answer);
        String givenAnswer = options.get(answerOption -1);
        return givenAnswer.equals(correctAnswer);
    }
}
