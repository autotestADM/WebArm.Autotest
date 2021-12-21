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

    public void returnRegisterOfDocuments() {
        click(By.linkText("Назад"));
    }

    public void submitDocumentCreation() {
        click(By.xpath("//button[@type ='submit']"));
    }

    private void click(By locator) {
        webd.findElement(locator).click();
    }

    public void fillDocumentForm(DocData docData) {
        type(By.id("info_document_edit_docno"), docData.numberOfDocument());
        dropDown(By.id("info_document_edit_doctype_id"), docData.typeOfDocument());
    }

    private void dropDown(By locator, String text) {
        click(locator);
        new Select(webd.findElement(locator)).selectByVisibleText(text);
    }

    private void type(By locator, String text) {
        click(locator);
        webd.findElement(locator).clear();
        webd.findElement(locator).sendKeys(text);
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
