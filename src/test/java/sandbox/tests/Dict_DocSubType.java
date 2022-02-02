package sandbox.tests;

import org.junit.Test;
import sandbox.model.M_Dict_DocSubType;

public class Dict_DocSubType extends TestBase {

    @Test
    public void testCreation(){
        app.getNavigationHelper().gotoNSI("Подтипы документов");
        app.getDocSubType_helper().initCreation();
        app.getDocSubType_helper().fillForm(new M_Dict_DocSubType().withType("40"));
    }
}
