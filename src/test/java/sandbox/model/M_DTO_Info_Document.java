package sandbox.model;

public class M_DTO_Info_Document {
    String typeOfDocument;
    String numberOfDocument;


    public M_DTO_Info_Document withType(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
        return this;
    }
    public M_DTO_Info_Document withNumber(String numberOfDocument) {
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