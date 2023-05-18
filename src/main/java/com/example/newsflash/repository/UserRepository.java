package com.example.newsflash.repository;

import com.example.newsflash.model.User;
import com.example.newsflash.model.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String Email);

    @Query("SELECT e.id, e.userName from User e")
    List<Object[]> getUsernames();

    default List<Username> allUsernames(){
        List<Object[]> objectList = getUsernames();
        List<Username> usernames = new ArrayList<>();
        for (Object[] obj : objectList) {
            Username username = Username.builder()
                    .id((Integer) obj[0])
                    .userName((String) obj[1])
                    .build();
            usernames.add(username);
        }
        return usernames;
    }


}
