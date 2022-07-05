package ru.netology.ProductManagerJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Death on the Nile", 3, "Agatha Christie");
    Product book1 = new Book(2, "The hound of the Baskervilles", 450, "Arthur Conan Doyle");
    Product smartphone = new Smartphone(3, "iPhone 12", 30_000, "Apple");
    Product book3 = new Book(3, "The girl with the dragon tattoo", 0, "Stieg Larsson");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        manager.add(book3);
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = new Product[]{book, book1, smartphone, book3};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Agatha Christie");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("The hound of the Baskervilles");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBookAndAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("The girl with the dragon tattoo" + "Stieg Larsson");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBookAndId() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("The girl with the dragon tattoo" + 3);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("iPhone 12");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneManufacturer() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Apple");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneManufacturerAndCost() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Apple" + 30_000);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindId() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("3");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindCost() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("30_000");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindCostNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("0");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Someone");
        Assertions.assertArrayEquals(expected, actual);
    }

}
