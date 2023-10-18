package webUI.pagesTodoIst;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class WorkspacePage {
    public Button profileButton = new Button(By.id(":r3:"));
    public Button addTaskButton = new Button(By.xpath("//button[@class='plus_add_button']"));
    public TextBox taskNameTextBox = new TextBox(By.xpath("//div[@contenteditable='true' and @aria-label='Nombre de la tarea']"));
    public Button submitTaskButton = new Button(By.xpath("//button[@data-testid='task-editor-submit-button']"));
    public Button taskCreateTextBox = new Button(By.xpath("//div[@class='e3d32437 _2a3b75a1']"));
}
