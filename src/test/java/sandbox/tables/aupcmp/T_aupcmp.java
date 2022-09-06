package sandbox.tables.aupcmp;

public class T_aupcmp {
    private String id;
    private String typeOfFile;
    private String period;
    private String file;
    private String date;
    private String user;
    private Boolean data;
    private String comment;
    private String delete;


    public String getId() {
        return id;
    }

    public T_aupcmp withId(String id) {
        this.id = id;
        return this;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }

    public T_aupcmp withTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
        return this;
    }

    public String getPeriod() {
        return period;
    }

    public T_aupcmp withPeriod(String period) {
        this.period = period;
        return this;
    }

    public String getFile() {
        return file;
    }

    public T_aupcmp withFile(String file) {
        this.file = file;
        return this;
    }

    public String getDate() {
        return date;
    }

    public T_aupcmp withDate(String date) {
        this.date = date;
        return this;
    }

    public String getUser() {
        return user;
    }

    public T_aupcmp withUser(String user) {
        this.user = user;
        return this;
    }

    public Boolean getData() {
        return data;
    }

    public T_aupcmp withData(Boolean data) {
        this.data = data;
        return this;
    }

}

