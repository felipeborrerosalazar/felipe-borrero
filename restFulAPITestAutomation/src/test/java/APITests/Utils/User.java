package APITests.Utils;

import lombok.Data;
@Data
public class User {
    private int id = 0;
    private String username = "testUser1";
    private String firstName = "firstName1";
    private String lastName = "lastName1";
    private String email = "testUser1@email.com";
    private String password = "12345";
    private String phone = "12345";
    private int userStatus = 1;
}
