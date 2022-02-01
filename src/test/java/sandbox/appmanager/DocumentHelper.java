package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sandbox.model.M_DTO_Info_Document;

public class DocumentHelper extends HelperBase{

    public DocumentHelper(WebDriver webd) {
        super(webd);
    }

    public void fillDocumentForm(M_DTO_Info_Document mDtoInfoDocument) {
        type(By.id("info_document_edit_docno"), mDtoInfoDocument.getNumberOfDocument());
        dropDown(By.id("info_document_edit_doctype_id"), mDtoInfoDocument.getTypeOfDocument());
    }

    public void deleteDocument() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                "'ТЕСТ Сотников Александр Игоревич'])[2]/following::*[name()='svg'][2]"));
        click(By.id("deletebtn"));
    }

    public void modificationDocument() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                "'ТЕСТ Сотников Александр Игоревич'])[2]/following::*[name()='svg'][1]"));
    }

}
