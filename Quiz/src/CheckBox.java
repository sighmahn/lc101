import java.util.ArrayList;

public class CheckBox extends Question {

    private ArrayList<String> correctAnswers;

    public CheckBox(String prompt) {
        super(prompt);
        this.correctAnswers = new ArrayList<>();
    }

    public void addAnswer(String answer) {
       correctAnswers.add(answer);
    }

    public void addOption(String option) {
        options.add(option);
    }

    @Override
    public boolean isCorrect(String answer) {
        if(answer.length() != correctAnswers.size()) {
            return false;
        }

        ArrayList<Integer> givenAnswers = new ArrayList<>();
        for(char c : answer.toCharArray()) {
            int answerOption = Integer.parseInt(c + "");
            if(givenAnswers.contains(answerOption)) {
                return false;
            }
            givenAnswers.add(answerOption);
            String givenAnswer = options.get(answerOption -1);
            if(!correctAnswers.contains(givenAnswer)) {
                return false;
            }
        }
        return true;
    }
}
