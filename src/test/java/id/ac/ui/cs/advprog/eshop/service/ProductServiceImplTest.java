package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void createDelegatesToRepositoryAndReturnsProduct() {
        Product product = new Product();

        Product result = productService.create(product);

        verify(productRepository).create(product);
        assertSame(product, result);
    }

    @Test
    void findAllMapsIteratorToList() {
        Product product1 = new Product();
        Product product2 = new Product();
        Iterator<Product> iterator = List.of(product1, product2).iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        verify(productRepository).findAll();
        assertEquals(2, result.size());
        assertEquals(product1, result.get(0));
        assertEquals(product2, result.get(1));
    }

    @Test
    void findAllReturnsEmptyListWhenRepositoryIsEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyIterator());

        List<Product> result = productService.findAll();

        verify(productRepository).findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    void editDelegatesToRepository() {
        Product newProduct = new Product();
        Product editedProduct = new Product();
        when(productRepository.edit("id-1", newProduct)).thenReturn(editedProduct);

        Product result = productService.edit("id-1", newProduct);

        verify(productRepository).edit("id-1", newProduct);
        assertSame(editedProduct, result);
    }

    @Test
    void findByIdDelegatesToRepository() {
        Product product = new Product();
        when(productRepository.findbyId("id-2")).thenReturn(product);

        Product result = productService.findbyId("id-2");

        verify(productRepository).findbyId("id-2");
        assertSame(product, result);
    }

    @Test
    void deleteDelegatesToRepository() {
        productService.delete("id-3");

        verify(productRepository).delete("id-3");
    }
}
