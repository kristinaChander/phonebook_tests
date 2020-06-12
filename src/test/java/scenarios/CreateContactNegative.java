package scenarios;

import constants.Constants;
import dto.ContactsDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AssertionsContacts;
import services.RequestServices;

public class CreateContactNegative {
    private RequestServices requestServices;

    @BeforeMethod
    public void setUp() {
        requestServices = new RequestServices();
    }

    @Test(groups = {"negative"},
            description = "checking if the service allows to create a contact with a phone number in wrong format" )
    public void createContactPhoneWrongFormat(){
        int userId = requestServices.addUser(Constants.USER_FIRST_NAME).getId();
        ContactsDTO contactCreationResponse = requestServices.addContact(Constants.PHONE_NUMBER_WRONG_FORMAT, userId);

        new AssertionsContacts(contactCreationResponse)
                .verifyContactsAnswerNotEmptyBody()
                .verifyCreatedContactPhone(Constants.ERROR_MESSAGE_WRONG_PHONE_FORMAT);
    }
}
