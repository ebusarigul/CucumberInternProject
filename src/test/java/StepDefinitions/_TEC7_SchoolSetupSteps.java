package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class _TEC7_SchoolSetupSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (int i = 0; i < listElements.size() ; i++) {
            ln.findAndClick(listElements.get(i));
        }

    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (int i = 0; i < listElements.size() ; i++) {
            dc.findAndClick(listElements.get(i));
        }


    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog() {
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogButton");
    }
}
