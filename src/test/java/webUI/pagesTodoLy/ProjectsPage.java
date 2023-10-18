package webUI.pagesTodoLy;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class ProjectsPage {
    public TextBox inputNewProject = new TextBox(By.id("NewProjNameInput"));

    public Button addProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public Button addButton = new Button(By.id("NewProjNameButton"));
    public TextBox nameProject = new TextBox(By.id("CurrentProjectTitle"));

}
