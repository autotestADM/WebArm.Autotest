package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sandbox.model.M_DTO_Info_Document;
import sandbox.model.M_Dict_DocSubType;

public class Dict_DocSubType_Helper extends HelperBase{

    public Dict_DocSubType_Helper(WebDriver webd) {
        super(webd);
    }
    public void fillForm(M_Dict_DocSubType docSubType) {
        dropDown(By.id("info_document_edit_docno"), docSubType.getType());
        dropDown(By.id("info_document_edit_doctype_id"), docSubType.getCountry());
    }
}
