package scenarios;

import constants.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AssertionsContacts;
import services.RequestServices;

public class DeleteContactPositive {
    private RequestServices requestServices;

    @BeforeMethod(groups = {"positive"})
    public void setUp() {
        requestServices = new RequestServices();
    }

    @Feature(value = "Contact deleting")
    @Story(value = "Delete a contact with existing Id")
    @Test(groups = {"positive"},
            description = "checking the possibility to delete existing user contact")
    public void deleteExistingContact() {
        int userId = requestServices.addUser(Constants.USER_FIRST_NAME1).getId();
        int contactId = requestServices.addContact(Constants.PHONE_NUMBER, userId).getId();
        Response contactCreationResponse = requestServices.deleteContact(userId, contactId);

        new AssertionsContacts(contactCreationResponse)
                .verifyResponseCodeDeleted()
                .verifyContactsAnswerEmptyBody();
    }
}
