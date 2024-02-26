public class Record {

    String term, statement;
    Double confidence;

    public Record(String term, String statement, Double confidence) {
        this.term = term;
        this. statement = statement;
        this.confidence = confidence;
    }

    public Record(Record other) {
        this.term = other.term;
        this.statement = other.statement;
        this.confidence = other.confidence;
    }

    public String getTerm() {
        return this.term;
    }

    public String getStatement() {
        return this.statement;
    }

    public Double getConfidence() {
        return this.confidence;
    }

    public String toString() {
        return term + " " + statement + " " + confidence;
    }

    public Boolean equals(Record other) {
        return other.term.equals(this.term) && other.statement.equals(this.statement) && other.confidence.equals(this.confidence);
    }
}
