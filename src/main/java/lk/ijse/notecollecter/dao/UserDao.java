package lk.ijse.notecollecter.dao;

import lk.ijse.notecollecter.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository <UserEntity,String>{
}
