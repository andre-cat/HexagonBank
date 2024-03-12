package co.com.hexagonbank.api;

import co.com.hexagonbank.api.data.CreateUserInfo;
import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.exceptions.UserExistsException;
import co.com.hexagonbank.model.user.exceptions.UserNotFoundException;
import co.com.hexagonbank.usecase.userservice.createuser.CreateUserUseCase;
import co.com.hexagonbank.usecase.userservice.seeuser.SeeUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1")
public class UserRest {

    private final SeeUserUseCase seeUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    @GetMapping("/user")
    public ResponseEntity<Object> seeUser(@RequestParam("id") long id) {
        try {
            User user = seeUserUseCase.see(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserInfo createUserInfo) {
        try {
            User user = createUserInfo.toUser();
            user = createUserUseCase.create(user);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body("User created:\n"
                            .concat("id: " + user.getId() + "\n")
                            .concat("username: " + user.getUsername() + "\n")
                            .concat("name: " + user.getName() + "\n")
                            .concat("last name: " + user.getLastName() + "\n")
                            .concat("phone: " + user.getPhone() + "\n")
                            .concat("email: " + user.getEmail())
                    );
        } catch (UserExistsException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }
}
