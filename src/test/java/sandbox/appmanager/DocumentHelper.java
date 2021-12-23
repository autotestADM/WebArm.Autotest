package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sandbox.model.DocData;

public class DocumentHelper extends HelperBase{

    public DocumentHelper(WebDriver webd) {
        super(webd);
    }

    public void returnRegisterOfDocuments() {
        click(By.linkText("Назад"));
    }

    public void submitDocumentCreation() {
        click(By.xpath("//button[@type ='submit']"));
    }

    public void fillDocumentForm(DocData docData) {
        type(By.id("info_document_edit_docno"), docData.numberOfDocument());
        dropDown(By.id("info_document_edit_doctype_id"), docData.typeOfDocument());
    }

    public void initDocumentCreation() {
        click(By.linkText("Создать"));
    }

    public void deleteDocument() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                "'ТЕСТ Сотников Александр Игоревич'])[2]/following::*[name()='svg'][2]"));
        click(By.id("deletebtn"));
    }
}
