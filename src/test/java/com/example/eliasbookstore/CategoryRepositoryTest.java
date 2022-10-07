package com.example.eliasbookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.eliasbookstore.domain.Category;
import com.example.eliasbookstore.domain.CategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

	 @Autowired
	 private CategoryRepository crepository;
	 
	 @Test
	 public void findCategory() {
		 List<Category> categories = crepository.findByName("FirstCategory");
		 assertThat(categories).hasSize(1);
		 assertThat(categories.get(0).getName()).isEqualTo("FirstCategory");
	 }
	 
	 @Test
	 public void createAndDeleteCategory() {
		 Category categories = new Category("FirstCategory");
		 crepository.save(categories);
		 assertThat(crepository.findById(categories.getCategoryid())).isNotEmpty();
		 crepository.delete(categories);
		 assertThat(crepository.findById(categories.getCategoryid())).isEmpty();
		 
	 }
	 
}
