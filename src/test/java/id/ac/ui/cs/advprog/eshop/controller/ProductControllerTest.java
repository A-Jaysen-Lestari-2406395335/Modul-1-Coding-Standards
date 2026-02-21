package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService service;

    private ProductController controller;

    @BeforeEach
    void setUp() {
        controller = new ProductController();
        ReflectionTestUtils.setField(controller, "service", service);
    }

    @Test
    void createProductPageAddsProductAndReturnsView() {
        Model model = new ExtendedModelMap();

        String viewName = controller.createProductPage(model);

        assertEquals("createProduct", viewName);
        assertEquals(Product.class, model.getAttribute("product").getClass());
    }

    @Test
    void createProductCallsServiceAndRedirects() {
        Product product = new Product();
        Model model = new ExtendedModelMap();

        String viewName = controller.createProduct(product, model);

        verify(service).create(product);
        assertEquals("redirect:list", viewName);
    }

    @Test
    void productListPageAddsAllProductsAndReturnsView() {
        Product product = new Product();
        List<Product> products = List.of(product);
        when(service.findAll()).thenReturn(products);
        Model model = new ExtendedModelMap();

        String viewName = controller.productlistPage(model);

        verify(service).findAll();
        assertEquals("productList", viewName);
        assertEquals(products, model.getAttribute("allProduct"));
    }

    @Test
    void editProductPageReturnsEditViewWhenProductExists() {
        Product product = new Product();
        product.setProductId("product-1");
        when(service.findbyId("product-1")).thenReturn(product);
        Model model = new ExtendedModelMap();

        String viewName = controller.editProductPage("product-1", model);

        verify(service).findbyId("product-1");
        assertEquals("editProduct", viewName);
        assertEquals(product, model.getAttribute("product"));
    }

    @Test
    void editProductPageRedirectsWhenProductDoesNotExist() {
        when(service.findbyId("product-1")).thenReturn(null);
        Model model = new ExtendedModelMap();

        String viewName = controller.editProductPage("product-1", model);

        verify(service).findbyId("product-1");
        assertEquals("redirect:/product/list", viewName);
        assertNull(model.getAttribute("product"));
    }

    @Test
    void editProductPostCallsServiceAndRedirects() {
        Product product = new Product();
        product.setProductId("product-2");
        Model model = new ExtendedModelMap();

        String viewName = controller.editProductPost("unused-path-id", product, model);

        verify(service).edit("product-2", product);
        assertEquals("redirect:/product/list", viewName);
    }

    @Test
    void deleteProductPostCallsServiceAndRedirects() {
        Model model = new ExtendedModelMap();

        String viewName = controller.deleteProductPost("product-3", model);

        verify(service).delete("product-3");
        assertEquals("redirect:/product/list", viewName);
    }
}
