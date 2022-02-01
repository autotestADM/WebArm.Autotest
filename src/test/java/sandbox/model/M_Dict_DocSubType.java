package sandbox.model;

public class M_Dict_DocSubType {
    String type;
    String subtype;
    String timeZone;
    String side;
    String foundation;
    String country;

    public M_Dict_DocSubType withType(String type) {
        this.type = type;
        return this;
    }

    public M_Dict_DocSubType withSubtype(String subtype) {
        this.subtype = subtype;
        return this;
    }

    public M_Dict_DocSubType withTimezone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }
    public M_Dict_DocSubType withSide(String side) {
        this.side = side;
        return this;
    }
    public M_Dict_DocSubType withFoundation(String foundation) {
        this.foundation = foundation;
        return this;
    }
    public M_Dict_DocSubType withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getSide() {
        return side;
    }

    public String getFoundation() {
        return foundation;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "M_Dict_DocSubType{" +
                "type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", side='" + side + '\'' +
                ", foundation='" + foundation + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
