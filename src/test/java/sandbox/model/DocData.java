package sandbox.model;

public class DocData {
    String typeOfDocument;
    String numberOfDocument;


    public DocData withType(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
        return this;
    }
    public DocData withNumber(String numberOfDocument) {
        this.numberOfDocument = numberOfDocument;
        return this;
    }

    public String getNumberOfDocument() {
        return numberOfDocument;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    @Override
    public String toString() {
        return "DocData{" +
                "typeOfDocument='" + typeOfDocument + '\'' +
                ", numberOfDocument='" + numberOfDocument + '\'' +
                '}';
    }
}