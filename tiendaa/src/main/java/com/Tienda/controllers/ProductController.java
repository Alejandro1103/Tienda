package com.tienda.controllers;
import com.Tienda.entities.Product;
import com.Tienda.service.IProductService;
import java.lang.annotation.Annotation;
import java.util.Optional;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product")
    public String index(Model model, @RequestParam("lowerPrice") Optional<Integer> lowerPrice, @RequestParam("higherPrice") Optional<Integer> higherPrice) {

 

        var baseProduct = new Product();
        baseProduct.setCategory(new Category() {
            @Override
            public String[] value() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        model.addAttribute("productDefault", baseProduct);
        model.addAttribute("products", this.productService.getProductsWithFilters(lowerPrice, higherPrice));
        model.addAttribute("categories", this.categoryService.getAll())
        return "product";
    }

    private class categoryService {

        public categoryService() {
        }
    }

 

}