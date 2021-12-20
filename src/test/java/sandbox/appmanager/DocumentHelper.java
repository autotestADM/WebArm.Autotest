package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import sandbox.model.DocData;

public class DocumentHelper {
    private WebDriver webd;

    public DocumentHelper(WebDriver webd) {
        this.webd = webd;
    }

    public void returnRegisterofDocuments() {
        webd.findElement(By.linkText("Назад")).click();
    }

    public void submitDocumentCreation() {
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void fillDocumentForm(DocData docData) {
        webd.findElement(By.id("info_document_edit_docno")).click();
        webd.findElement(By.id("info_document_edit_docno")).clear();
        webd.findElement(By.id("info_document_edit_docno")).sendKeys(docData.numberOfDdocument());
        webd.findElement(By.id("info_document_edit_doctype_id")).click();
        new Select(webd.findElement(By.id("info_document_edit_doctype_id"))).selectByVisibleText(docData.typeOfDocument());
    }

    public void initDocumentCreation() {
        webd.findElement(By.linkText("Создать")).click();
    }

    public void deleteDocument() {
        webd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                "'ТЕСТ Сотников Александр Игоревич'])[2]/following::*[name()='svg'][2]")).click();
        webd.findElement(By.id("deletebtn")).click();
    }
}
