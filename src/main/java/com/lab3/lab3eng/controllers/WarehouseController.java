package com.lab3.lab3eng.controllers;

import com.lab3.lab3eng.model.Warehouse;
import com.lab3.lab3eng.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseRepo warehouseRepo;

    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepo.findAll();
    }

    @PostMapping("/warehouses")
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }

    @PutMapping("/warehouses/{id}")
    public Warehouse updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse updatedWarehouse) {
        Optional<Warehouse> warehouseOptional = warehouseRepo.findById(id);
        if (warehouseOptional.isPresent()) {
            Warehouse existingWarehouse = warehouseOptional.get();
            existingWarehouse.setAddress(updatedWarehouse.getAddress());
            existingWarehouse.setCity(updatedWarehouse.getCity());
            // Update other fields as needed
            return warehouseRepo.save(existingWarehouse);
        } else {
            // Handle case where warehouse with given id is not found
            return null;
        }
    }

    @DeleteMapping("/warehouses/{id}")
    public void deleteWarehouse(@PathVariable Integer id) {
        warehouseRepo.deleteById(id);
    }
}
