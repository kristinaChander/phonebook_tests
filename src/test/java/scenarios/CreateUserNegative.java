package scenarios;

import constants.Constants;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AssertionsUser;
import services.RequestServices;

public class CreateUserNegative {
    private RequestServices requestServices;

    @BeforeMethod
    public void setUp() {
        requestServices = new RequestServices();
    }

    @Test(groups = {"negative"},
            description = "checking the possibility to create a user with the name length less than 2 characters")
    public void createUserTooShortName(){
        UserDTO userCreationResponse = requestServices
                .addUser(Constants.USER_FIRST_NAME_WRONG_FORMAT);

        new AssertionsUser(userCreationResponse)
                .verifyUserAnswerNotEmptyBody()
                .verifyCreatedUserName(Constants.ERROR_MESSAGE_FIRST_NAME_WRONG_LENGTH);
    }
}
