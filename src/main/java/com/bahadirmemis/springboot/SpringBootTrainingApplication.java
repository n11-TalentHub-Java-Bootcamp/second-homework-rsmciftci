package com.bahadirmemis.springboot;

import com.bahadirmemis.springboot.entity.Category;
import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.service.entityservice.CategoryService;
import com.bahadirmemis.springboot.service.entityservice.ProductService;
import com.bahadirmemis.springboot.service.entityservice.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootTrainingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootTrainingApplication.class, args);

		CategoryService categoryService = applicationContext.getBean(CategoryService.class);
		ProductService productService = applicationContext.getBean(ProductService.class);
		UserService userService = applicationContext.getBean(UserService.class);

	}

	private static void saveBook(CategoryService categoryService) {
		Category book = new Category();
		book.setName("Kitap");
		book.setBreakdown(1L);

		book = categoryService.save(book);

		Category bookLowerBreakdown = new Category();
		bookLowerBreakdown.setBreakdown(2L);
		bookLowerBreakdown.setName("Kitap");
		bookLowerBreakdown.setUpperCategory(book);

		categoryService.save(bookLowerBreakdown);
	}

	private static void findAllProductList(ProductService productService) {
		List<Product> productList = productService.findAll();

		for (Product product : productList) {
			System.out.println(product.getName());
		}
	}

	private static void findAllProductList(CategoryService categoryService) {
		List<Category> categoryList = categoryService.findAll();

		for (Category category : categoryList) {
			System.out.println(category.getName());
		}
	}

	private static void deleteProductList(ProductService productService) {
		List<Long> listOfProductsToBeDeleted = Arrays.asList(102L, 152L, 202L, 252L, 302L);

		for (Long productId : listOfProductsToBeDeleted) {
			productService.deleteById(productId);
		}
	}

	private static void getSamsungM31(CategoryService categoryService, ProductService productService) {
		Category category = categoryService.findById(502L);

		Product product = new Product();
		product.setName("Samsung M31");
		product.setPrice(new BigDecimal("3000"));
		product.setRegistrationDate(new Date());
		product.setCategory(category);

		product = productService.save(product);

		System.out.println(product);
	}

	private static Category getPhoneCategory(CategoryService categoryService) {
		Category upperCategory = categoryService.findById(2L);

		System.out.println(upperCategory);

		Category category = new Category();
		category.setName("Telefon");
		category.setBreakdown(2L);
		category.setUpperCategory(upperCategory);

		category = categoryService.save(category);

		System.out.println(category);

		return category;
	}

}
