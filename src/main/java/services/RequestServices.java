package services;

import constants.Constants;
import dto.ContactsDTO;
import dto.UserDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestServices {

    public RequestSpecification createRequestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
                .setBaseUri(PropertyUtil.TEST_PROPERTIES.getProperty("baseURI"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addHeader("Content-Type", "application/json")
                .build();
    }

    public UserDTO userDTO(String firstName) {
        return UserDTO.builder()
                .firstName(firstName)
                .build();
    }

    public ContactsDTO contactsDTO(String phone) {
        return ContactsDTO.builder()
                .phone(phone)
                .build();
    }

    public UserDTO addUser(String firstName) {
        Response response = given(createRequestSpecification())
                .body(userDTO(firstName))
                .post(Constants.ADD_USER_ENDPOINT);
        return response.getBody().as(UserDTO.class);
    }

    public ContactsDTO addContact(String phone, int userId) {
        Response response = given(createRequestSpecification())
                .body(contactsDTO(phone))
                .post(String.format(Constants.ADD_CONTACT_PATH_TEMPLATE, userId));
        return response.getBody().as(ContactsDTO.class);
    }

    public Response deleteContact(int userId, int contactId) {
        return given(createRequestSpecification())
                .delete(String.format(Constants.DELETE_CONTACT_PATH_TEMPLATE, userId, contactId));
    }
}
