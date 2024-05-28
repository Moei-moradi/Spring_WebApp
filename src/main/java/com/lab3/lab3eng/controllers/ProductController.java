package com.lab3.lab3eng.controllers;

import com.lab3.lab3eng.model.*;
import com.lab3.lab3eng.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ToysRepo toysRepo;

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private MedicineRepo medicineRepo;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @PostMapping("/products/toys")
    public Toys createToys(@RequestBody Toys toys) {
        return toysRepo.save(toys);
    }

    @PostMapping("/products/food")
    public Food createFood(@RequestBody Food food) {
        return foodRepo.save(food);
    }

    @PostMapping("/products/medicine")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setTitle(updatedProduct.getTitle());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setQty(updatedProduct.getQty());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setManufacturer(updatedProduct.getManufacturer());
            existingProduct.setWeight(updatedProduct.getWeight());
            return productRepo.save(existingProduct);
        } else {
            return null;
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepo.deleteById(id);
    }

}
