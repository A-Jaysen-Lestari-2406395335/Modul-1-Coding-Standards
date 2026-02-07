package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product edit(String id, Product newProduct) {
        Optional<Product> productOptional = Optional.ofNullable(findbyId(id));

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductName(newProduct.getProductName());
            product.setProductQuantity(newProduct.getProductQuantity());
            return product;
        }
        return null;
    }

    public Product findbyId(String id) {
        for (Product product: productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
