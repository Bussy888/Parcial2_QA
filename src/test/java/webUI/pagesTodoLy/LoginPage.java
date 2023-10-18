package webUI.pagesTodoLy;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class LoginPage {
    public Button signupButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
    public TextBox fullnameSignTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBoxSign = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));

    public TextBox passwordTextBoxSign = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));

    public Button termsCheck = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
}
