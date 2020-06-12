package services;

import dto.ContactsDTO;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsContacts {

    private ContactsDTO contactsDTO;
    private Response contactsResponse;

    public AssertionsContacts(ContactsDTO contactsDTO) {
        this.contactsDTO = contactsDTO;
    }

    public AssertionsContacts(Response contactsResponse) {
        this.contactsResponse = contactsResponse;
    }

    public AssertionsContacts verifyContactsAnswerNotEmptyBody() {
        assertThat(contactsDTO).isNotNull();
        return this;
    }

    public AssertionsContacts verifyContactsAnswerEmptyBody() {
        assertThat(contactsResponse.getBody().asString()).isEmpty();
        return this;
    }

    public AssertionsContacts verifyResponseCodeDeleted() {
        assertThat(contactsResponse.getStatusCode()).isEqualTo(202);
        return this;
    }

    public AssertionsContacts verifyCreatedContactPhone(String phone) {
        assertThat(contactsDTO.getPhone().equals(phone));
        return this;
    }

}
