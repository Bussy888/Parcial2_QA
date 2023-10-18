package ejercicio4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.LoginPage;
import webUI.pages.MainPage;
import webUI.session.Session;

public class Ejercicio2 {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    String fullname = "Mateo Michel";
    String email = "sawova4461@ibtrades.com";
    String password = "Contra12345";//Pass12345

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }
    @Test
    public void loginTesting() throws InterruptedException {
        mainPage.signUpButton.click();
        Thread.sleep(1000);
        loginPage.fullnameSignTextBox.setText(fullname);
        loginPage.emailTextBoxSign.setText(email);
        loginPage.passwordTextBoxSign.setText(password);
        loginPage.termsCheck.click();
        loginPage.signupButton.click();
        Thread.sleep(1000);
        mainPage.loginButton.click();
        Thread.sleep(1000);
        loginPage.emailTextBoxLogin.setText(fullname);
        loginPage.passwordTextBoxLogin.setText(password);
        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion");
    }
}
