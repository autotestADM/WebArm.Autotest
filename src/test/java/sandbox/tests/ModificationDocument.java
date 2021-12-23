package sandbox.tests;

import org.junit.Test;
import sandbox.model.DocData;

public class ModificationDocument extends TestBase {
    @Test
    public void testModificationDocument() {
        app.getNavigationHelper().gotoRegisterOfDocuments();
        app.getDocumentHelper().modificationDocument();
        app.getDocumentHelper().fillDocumentForm(new DocData(null, "Тест3"));
        app.getDocumentHelper().submitDocumentCreation();
    }
}
