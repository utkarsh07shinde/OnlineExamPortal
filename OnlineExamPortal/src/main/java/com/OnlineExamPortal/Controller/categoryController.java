package com.OnlineExamPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OnlineExamPortal.entity.Category;
import com.OnlineExamPortal.services.categoryService;

@Controller
@RequestMapping("category")
public class categoryController {

	@Autowired
	private categoryService categoryService;
	
	@GetMapping("/")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categories";
    }

    @GetMapping("/new")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/category/";
    }

    @GetMapping("/{categoryId}")
    public String getCategory(@PathVariable Long categoryId, Model model) {
        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("category", category);
        return "categoryDetail";
    }

    @GetMapping("/edit/{categoryId}")
    public String showEditCategoryForm(@PathVariable Long categoryId, Model model) {
        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("category", category);
        return "categoryForm";
    }

    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable Long categoryId, @ModelAttribute Category category, Model model) {
    	category.setCatId(categoryId);
        if (categoryService.getCategory(categoryId) != null) {
            categoryService.updateCategory(category);
            return "redirect:/category/";
        }
        model.addAttribute("error", "Category with id: " + categoryId + " doesn't exist");
        return "errorPage";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/category/";
    }
	
	
	
}
