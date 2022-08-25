package sandbox.tests;

import org.junit.Test;

public class Aupcmp extends TestBase{

    @Test
    public void testDate(){
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getNavigationHelper().setDate("01.06.2022","30.06.2022");
    }
}
