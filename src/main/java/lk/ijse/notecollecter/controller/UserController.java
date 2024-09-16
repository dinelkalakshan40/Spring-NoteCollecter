package lk.ijse.notecollecter.controller;

import lk.ijse.notecollecter.dto.impl.UserDTO;
import lk.ijse.notecollecter.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
          @RequestPart("firstName") String firstName,
          @RequestPart("lastName")  String lastName,
          @RequestPart("email")  String email,
          @RequestPart("password")  String password,
          @RequestPart("profilePic")  String profilePic

    ){
       String base64ProPic= AppUtil.profilePicToBase64(profilePic);
       String userId = AppUtil.generateNoteId();

      var buildUserDTO=  new UserDTO();
      buildUserDTO.setUserId(userId);
      buildUserDTO.setFirstName(firstName);
      buildUserDTO.setLastName(lastName);
      buildUserDTO.setEmail(email);
      buildUserDTO.setPassword(password);
      buildUserDTO.setProfilePic(base64ProPic);

      return buildUserDTO;
    }
}
