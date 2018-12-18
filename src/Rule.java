/**
 * Created by Arnaud Labourel on 21/09/2018.
 */
public class Rule {
    private final char symbol;
    private final String sequence;

    public char getSymbol() {
        return symbol;
    }

    public String getSequence() {
        return sequence;
    }

    public Rule(char symbol, String sequence) {
        this.symbol = symbol;
        this.sequence = sequence;
    }
}
