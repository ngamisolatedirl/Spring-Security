package com.example.demo.controller2;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Products;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductsService productsService;

    // Admin Page
    @GetMapping("")
    public String adminPage() {
        return "subjects/adminPage";
    }

    // CRUD Category
    @GetMapping("/categories")
    public String viewCategoriesPage(Model model) {
        List<Categories> categoriesList = categoriesService.getAllCategories();
        model.addAttribute("categoriesList", categoriesList);
        return "subjects/categories";
    }

    @GetMapping("/createCategory")
    public String createCategory(Model model) {
        model.addAttribute("categories", new Categories());
        return "subjects/categoriesAdd";
    }

    @PostMapping("/createCategory")
    public String saveCategory(@ModelAttribute("categories") Categories categories) {
        categoriesService.addCategory(categories);
        return "redirect:/admin/categories";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        Optional<Categories> category = categoriesService.getCategoryById(id);
        category.ifPresent(value -> model.addAttribute("categories", value));
        return "subjects/editCategoryPage";
    }

    @PostMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute("categories") Categories categories) {
        categories.setId(id);
        categoriesService.addCategory(categories);
        return "redirect:/admin/categories";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoriesService.getCategoryById(id).ifPresent(categoriesService::removeCategory);
        return "redirect:/admin/categories";
    }

    // CRUD Product
    @GetMapping("/viewProducts")
    public String viewProductsPage(Model model) {
        List<Products> productsList = productsService.getAllProducts();
        model.addAttribute("productsList", productsList);
        return "subjects/products";
    }

    @GetMapping("/createProducts")
    public String createProductsPage(Model model) {
        model.addAttribute("products", new Products());
        model.addAttribute("categoriesList", categoriesService.getAllCategories());
        return "subjects/productsAdd";
    }
    @PostMapping("/createProducts")
    public String saveProducts(@ModelAttribute("products") Products products) {
        productsService.addProduct(products);
        return "redirect:/admin/viewProducts";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProductPage(Model model, @PathVariable Long id) {
        Optional<Products> product = productsService.getProductById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        model.addAttribute("categoriesList", categoriesService.getAllCategories());
        return "subjects/editProductPage";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Products products) {
        products.setId(id);
        productsService.addProduct(products);
        return "redirect:/admin/viewProducts";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productsService.getProductById(id).ifPresent(productsService::deleteProduct);
        return "redirect:/admin/viewProducts";
    }
}



















//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    @Autowired
//    CategoriesService CS;
//    @Autowired
//    ProductsService PS;
//
//    // CRUD Category
//    @GetMapping("/categories")
//    public String viewCategoriesPage(Model model) {
//        List<Categories> categoriesList = CS.getAllCategories();
//        model.addAttribute("categoriesList", categoriesList);
//        return "subjects/categories";
//    }
//
//    @GetMapping("/categories/{id}")
//    public String viewCategory(@PathVariable int id, Model model) {
//        Optional<Categories> categories = CS.getCategoriesById(id);
//        model.addAttribute("categories", categories);
//        return "subjects/categories";
//    }
//
//    @GetMapping("/createCategory")
//    public String createCategory(Model model) {
//        model.addAttribute("categories", new Categories());
//        return "subjects/categoriesAdd";
//    }
//
//    @GetMapping("/editCategory/{id}")
//    public String editCategory(@PathVariable int id, Model model) {
//        Optional<Categories> category = CS.getCategoriesById(id);
//        category.ifPresent(value -> model.addAttribute("categories", value));
//        return "subjects/editCategoryPage";
//    }
//
//    @PostMapping("/updateCategory/{id}")
//    public String updateCategory(@PathVariable int id, @ModelAttribute("categories") Categories categories) {
//        categories.setId(id);
//        CS.addCategories(categories);
//        return "redirect:/admin/categories";
//    }
//
//    @GetMapping("/deleteCategory/{id}")
//    public String deleteCategory(@PathVariable int id, Model model) {
//        CS.getCategoriesById(id).ifPresent(CS::removeCategories);
//        return "redirect:/admin/categories";
//    }
//
//    // CRUD Product
//    @GetMapping("/viewProducts")
//    public String viewProductsPage(Model model) {
//        List<Products> productsList = PS.getAllProducts();
//        model.addAttribute("productsList", productsList);
//        return "subjects/products";
//    }
//
//    @GetMapping("/viewProducts/{id}")
//    public String viewProducts(@PathVariable Long id, Model model) {
//        Optional<Products> products = PS.getProductById(id);
//        products.ifPresent(value -> model.addAttribute("products", value));
//        return "subjects/products";
//    }
//
//    @GetMapping("/createProducts")
//    public String createProductsPage(Model model) {
//        model.addAttribute("products", new Products());
//        model.addAttribute("categoriesList", CS.getAllCategories());
//        return "subjects/productsAdd";
//    }
//
//    @PostMapping
//    public String saveProducts(@ModelAttribute("products") Products products) {
//        PS.addProduct(products);
//        return "redirect:/admin/viewProducts";
//    }
//
//    @GetMapping("/updateProduct/{id}")
//    public String updateProductPage(Model model, @PathVariable Long id) {
//        Optional<Products> product = PS.getProductById(id);
//        product.ifPresent(value -> model.addAttribute("product", value));
//        model.addAttribute("categoriesList", CS.getAllCategories());
//        return "subjects/editProductPage";
//    }
//
//    @PostMapping("/updateProduct/{id}")
//    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Products products) {
//        products.setId(id);
//        PS.addProduct(products);
//        return "redirect:/admin/viewProducts";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        PS.getProductById(id).ifPresent(PS::deleteProduct);
//        return "redirect:/admin/viewProducts";
//    }

