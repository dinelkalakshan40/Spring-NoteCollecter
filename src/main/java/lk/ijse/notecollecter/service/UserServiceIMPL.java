package lk.ijse.notecollecter.service;

import jakarta.transaction.Transactional;
import lk.ijse.notecollecter.dao.UserDao;
import lk.ijse.notecollecter.dto.impl.UserDTO;
import lk.ijse.notecollecter.entity.impl.UserEntity;
import lk.ijse.notecollecter.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return mapping.toUserDTO(userDao.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser = userDao.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
       Optional <UserEntity> tmpUser = userDao.findById(userId);
       if (tmpUser.isPresent()){
           tmpUser.get().setFirstName(userDTO.getFirstName());
           tmpUser.get().setLastName(userDTO.getLastName());
           tmpUser.get().setEmail(userDTO.getEmail());
           tmpUser.get().setPassword(userDTO.getPassword());
           tmpUser.get().setProfilePic(userDTO.getProfilePic());
       }
    }
}
