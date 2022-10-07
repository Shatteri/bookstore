package com.example.eliasbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.eliasbookstore.domain.User;
import com.example.eliasbookstore.domain.UserRepository;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository urepository;

    @Test
    public void searchUser() {
        User users = urepository.findByUsername("user");

        assertThat(users).isNotNull();
        assertThat(users.getUsername().matches("user"));
    }

    @Test
	 public void createAndDeleteUser() {
		 User user = new User("test", "testpassword", "USER");
		 urepository.save(user);
		 assertThat(urepository.findById(user.getId())).isNotEmpty();
		 urepository.delete(user);
		 assertThat(urepository.findById(user.getId())).isEmpty();
		 
	 }


}
