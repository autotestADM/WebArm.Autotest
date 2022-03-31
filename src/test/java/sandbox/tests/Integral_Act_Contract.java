package sandbox.tests;

import org.junit.Test;

public class Integral_Act_Contract extends TestBase {
    @Test
    public void testIntegral_Act_Contract() {
        app.getNavigationHelper().gotoReports("Интегральный акт по договору");
        app.getIntegralActContractHelper().typeDatePeriod();
    }
}
