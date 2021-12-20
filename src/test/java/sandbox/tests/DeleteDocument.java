package sandbox.tests;

import org.junit.Test;


public class DeleteDocument extends TestBase {

    @Test
    public void testDeleteDocument() {
        app.gotoRegisterOfDocuments();
        app.deleteDocument();
    }

}
