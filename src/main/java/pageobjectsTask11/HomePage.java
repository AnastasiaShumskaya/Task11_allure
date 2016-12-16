package pageobjectsTask11;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;

public class HomePage {

    private static final String OFFICE_MENU_ID = "officeMenu";
    private static final String INPUT_SEARCH_CSS = "input-search";
    private static final String NAME_ID = "name";


    @FindBy(how = How.ID, using = OFFICE_MENU_ID)
    private SelenideElement officeTab;

    @FindBy(how = How.CSS, using = INPUT_SEARCH_CSS)
    private SelenideElement inputSearch;

    @FindBy(how = How.ID, using = NAME_ID)
    private SelenideElement name;

    public String linkName() {
        return name.getText();
    }

    public String getTitle() {
        return title();
    }

    public void goToOfficeTab() {
        officeTab.click();
    }
}
