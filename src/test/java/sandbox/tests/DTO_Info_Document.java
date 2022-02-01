package sandbox.tests;

import org.junit.*;
import sandbox.model.M_DTO_Info_Document;


public class DTO_Info_Document extends TestBase {

    @Test
    public void testCreationDocument() {
        app.getNavigationHelper().gotoRegisterOfDocuments();
        app.getDocumentHelper().initCreation();
        app.getDocumentHelper().fillDocumentForm(new M_DTO_Info_Document()
                .withType("Отклонения (инициативы)")
                .withNumber("Тест1"));
        app.getDocumentHelper().submitCreation();
        app.getDocumentHelper().goBack();
    }
    @Test
    public void testModificationDocument() {
        app.getNavigationHelper().gotoRegisterOfDocuments();
        app.getDocumentHelper().modificationDocument();
        app.getDocumentHelper().fillDocumentForm(new M_DTO_Info_Document().withNumber("Тест3"));
        app.getDocumentHelper().submitCreation();
    }
    @Test
    public void testDeleteDocument() {
        app.getNavigationHelper().gotoRegisterOfDocuments();
        app.getDocumentHelper().deleteDocument();
    }


}