package ejercicio4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pagesTodoIst.LoginPage;
import webUI.pagesTodoIst.MainPage;
import webUI.pagesTodoIst.WorkspacePage;
import webUI.session.Session;

import java.util.Date;

public class Ejercicio4 {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    WorkspacePage workspacePage = new WorkspacePage();


    String email = "sawova4461@ibtrades.com";
    String password = "Contra12345";//Pass12345
    String newPassword = "Pass12345";//Contra12345
    String nameTask= "Nueva Tarea"+new Date().getTime();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/");
    }
    @Test
    public void loginTesting() throws InterruptedException {
        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion");
        workspacePage.addTaskButton.click();
        workspacePage.taskNameTextBox.setText(nameTask);
        Thread.sleep(2000);
        workspacePage.submitTaskButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(workspacePage.taskCreateTextBox.isControlDisplayed(), "ERROR no se pudo iniciar sesion" +
                "la contrasena no se pudo cambiar");





    }
}
