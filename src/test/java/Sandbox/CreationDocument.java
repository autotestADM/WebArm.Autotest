package Sandbox;

import org.junit.*;


public class CreationDocument extends TestBase {

    @Test
    public void testCreationDocument() {
        gotoRegisterOfDocuments();
        initDocumentCreation();
        fillDocumentForm(new DocData("Отклонения (инициативы)", "Тест1"));
        submitDocumentCreation();
        returnRegisterofDocuments();
    }

}