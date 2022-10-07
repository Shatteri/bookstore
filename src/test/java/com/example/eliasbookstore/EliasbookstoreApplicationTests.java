package com.example.eliasbookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.eliasbookstore.web.BookController;
import com.example.eliasbookstore.web.UserController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EliasbookstoreApplicationTests {
	@Autowired
    private BookController bController;
    @Autowired
	private UserController uController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(bController).isNotNull();
        assertThat(uController).isNotNull();
    }	
}
