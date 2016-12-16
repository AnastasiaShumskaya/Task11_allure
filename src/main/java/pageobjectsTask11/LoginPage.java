package pageobjectsTask11;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class LoginPage {

    private static final String USERNAME_ID = "Username";
    private static final String PASSWORD_ID = "Password";
    private static final String SUBMITBUTTON_ID = "SubmitButton";

    @FindBy(how = How.ID, using = USERNAME_ID)
    private SelenideElement username;

    @FindBy(how = How.ID, using = PASSWORD_ID)
    private SelenideElement password;

    @FindBy(how = How.ID, using = SUBMITBUTTON_ID)
    private SelenideElement submitButton;

    public HomePage login(String name, String pass) {
        $(username).setValue(name);
        $(password).setValue(pass);
        $(submitButton).click();

        return page (HomePage.class);
    }

}