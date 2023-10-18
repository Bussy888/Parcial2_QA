package ejercicio3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pagesTodoLy.LoginPage;
import webUI.pagesTodoLy.MainPage;
import webUI.pagesTodoLy.ProjectsPage;
import webUI.session.Session;

import java.util.Date;

public class Ejercicio3 {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    ProjectsPage projectsPage = new ProjectsPage();

    String nameProject = "MateoM"+new Date().getTime();
    String fullname = "Mateo Michel";
    String email = nameProject+"@ibtrades.com";
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
        Thread.sleep(2000);

        projectsPage.addProjectButton.click();
        projectsPage.inputNewProject.setText(nameProject);
        projectsPage.addButton.click();
        Thread.sleep(2000);

        String actualResult= projectsPage.nameProject.getText();
        String expectedResult= nameProject;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR el projecto no se creo");

    }
}
