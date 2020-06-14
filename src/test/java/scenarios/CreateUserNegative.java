package scenarios;

import constants.Constants;
import dto.UserDTO;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AssertionsUser;
import services.RequestServices;

public class CreateUserNegative {
    private RequestServices requestServices;

    @BeforeMethod(groups = "negative")
    public void setUp() {
        requestServices = new RequestServices();
    }


    @Feature(value = "User creation")
    @Story(value = "Create a user with name length<2")
    @Test(groups = {"negative"},
            description = "checking the possibility to create a user with the name length less than 2 characters")
    public void createUserTooShortName() {
        UserDTO userCreationResponse = requestServices
                .addUser(Constants.USER_FIRST_NAME_WRONG_FORMAT);

        new AssertionsUser(userCreationResponse)
                .verifyUserAnswerNotEmptyBody()
                .verifyCreatedUserName(Constants.ERROR_MESSAGE_FIRST_NAME_WRONG_LENGTH);
    }
}
