package webUI.pagesTodoIst;

import org.openqa.selenium.By;
import webUI.controls.Button;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//li//a[@href=\"/auth/login\"]"));

}
