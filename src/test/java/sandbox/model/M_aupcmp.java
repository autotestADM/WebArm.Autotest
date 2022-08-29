package sandbox.model;

/**
 * Сравнение 51020 | Учетного показателя и 51070 (формирование 51075)
 */
public class M_aupcmp {
    private String startDate;   // Для поля "Период построения отчета", стартовая дата, ДД.ММ.ГГГГ
    private String finishDate;  // Для поля "Период построения отчета", конечная дата, ДД.ММ.ГГГГ
    private String section;     // Сечение, желательно номер сечения!
    private String aup_1;       // АУП 1, value
    private Boolean check_aup_2; //Чекбокс для расчета АУП2
    private String aup_2;       // АУП 2, value
    private String profile_TP;  // Профиль ТП, value

    public M_aupcmp() {
        this.aup_1="2";
        this.aup_2="2";
        this.check_aup_2=false;
        this.profile_TP="0";
    }

    public String getStartDate() {
        return startDate;
    }

    public M_aupcmp withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public M_aupcmp withFinishDate(String finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public String getSection() {
        return section;
    }

    public M_aupcmp withSection(String section) {
        this.section = section;
        return this;
    }

    public String getAup_1() {
        return aup_1;
    }

    public Boolean getCheck_aup_2() {
        return check_aup_2;
    }

    public M_aupcmp withCheck_aup_2(Boolean check_aup_2) {
        this.check_aup_2 = check_aup_2;
        return this;
    }

    public M_aupcmp withAup_1(String aup_1) {
        this.aup_1 = aup_1;
        return this;
    }

    public String getAup_2() {
        return aup_2;
    }

    public M_aupcmp withAup_2(String aup_2) {
        this.aup_2 = aup_2;
        return this;
    }

    public String getProfile_TP() {
        return profile_TP;
    }

    public M_aupcmp withProfile_TP(String profile_TP) {
        this.profile_TP = profile_TP;
        return this;
    }
}
