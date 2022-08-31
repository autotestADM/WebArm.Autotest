package sandbox;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LazTest {
    @Test
    public void testing() {
        LocalDate today = LocalDate.now();
        String startDate = "01.08.2022";
        String finishDate = "31.08.2022";
        int day = LocalDate.now().getDayOfMonth();
        LocalDate preStartDate = today.withDayOfMonth(1).minusMonths(1);
        LocalDate preFinishDate = preStartDate.withDayOfMonth(preStartDate.lengthOfMonth());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (day < 20) {
            Assert.assertEquals("Fail START date", preStartDate.format(dateTimeFormatter), startDate);
            Assert.assertEquals("Fail FINISH date", preFinishDate.format(dateTimeFormatter), finishDate);
        } else {
            Assert.assertEquals("Fail FINISH date", today.withDayOfMonth(1).format(dateTimeFormatter), startDate);
            Assert.assertEquals("Fail START date", today.format(dateTimeFormatter), finishDate);
        }


    }
}
