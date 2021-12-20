package sandbox.tests;

import org.junit.*;
import sandbox.model.DocData;


public class CreationDocument extends TestBase {

    @Test
    public void testCreationDocument() {
        app.gotoRegisterOfDocuments();
        app.initDocumentCreation();
        app.fillDocumentForm(new DocData("Отклонения (инициативы)", "Тест1"));
        app.submitDocumentCreation();
        app.returnRegisterofDocuments();
    }

}