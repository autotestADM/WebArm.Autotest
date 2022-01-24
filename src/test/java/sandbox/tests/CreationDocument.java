package sandbox.tests;

import org.junit.*;
import sandbox.model.DocData;


public class CreationDocument extends TestBase {

    @Test
    public void testCreationDocument() {
        app.getNavigationHelper().gotoRegisterOfDocuments();
        app.getDocumentHelper().initDocumentCreation();
        app.getDocumentHelper().fillDocumentForm(new DocData().withTypeOfDocument("Отклонения (инициативы)")
                .withNumberOfDocument("Тест1"));
        app.getDocumentHelper().submitDocumentCreation();
        app.getDocumentHelper().returnRegisterOfDocuments();
    }

}