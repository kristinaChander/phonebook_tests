package services;

import dto.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsUser {
    private UserDTO userDTO;

    public AssertionsUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public AssertionsUser verifyUserAnswerNotEmptyBody() {
        assertThat(userDTO).isNotNull();
        return this;
    }

    public AssertionsUser verifyCreatedUserName(String firstName) {
        assertThat(userDTO.getFirstName().equals(firstName));
        return this;
    }
}
