/**
 * Created by Arnaud Labourel on 21/09/2018.
 */
public class SetOfRules {
    private final Rule[] rules;

    public SetOfRules(Rule[] rules) {
        this.rules = rules;
    }

    private String apply(char symbol){
        for(Rule rule : rules){
            if(symbol == rule.getSymbol()){
                return rule.getSequence();
            }
        }
        return String.valueOf(symbol);
    }

    String apply(String sequence){
        StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; index<sequence.length(); index++){
            stringBuilder.append(apply(sequence.charAt(index)));
        }
        return stringBuilder.toString();
    }
}
