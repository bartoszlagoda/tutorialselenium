package io.github.testeroprogramowania.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {
    public boolean checkIfSelectExist(WebElement element, String selector){
        Select elements = new Select(element);
        List<WebElement> options = elements.getOptions();
        for(WebElement option : options){
            if(option.getText().equals(selector)){
                return true;
            }
        }
        return false;
    }
}
