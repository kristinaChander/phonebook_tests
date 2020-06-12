package scenarios;

import constants.Constants;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AssertionsUser;
import services.RequestServices;

public class CreateUserPositive {

    private RequestServices requestServices;

    @BeforeMethod(groups = "positive")
    public void setUp() {
        requestServices = new RequestServices();
    }

    @Test(groups = {"positive"},
            description = "checking user creation with name of appropriate length and format")
    public void createUserOnlyRequiredField() {
        UserDTO userCreationResponse = requestServices.addUser(Constants.USER_FIRST_NAME);

        new AssertionsUser(userCreationResponse)
                .verifyUserAnswerNotEmptyBody()
                .verifyCreatedUserName(Constants.USER_FIRST_NAME);
    }
}
