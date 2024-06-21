package in.codetech.angulareducloud.portal.controller;

import in.codetech.angulareducloud.portal.model.Category;
import in.codetech.angulareducloud.portal.repository.CategoryRepository;
import in.codetech.angulareducloud.portal.service.Impl.CategoryServiceImpl;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/category")
public class CategoryController {
  @Autowired
    private CategoryServiceImpl categoryService;

  @PostMapping("/save")
  public ResponseEntity<Category> addCatergory(@RequestBody Category category){
      Category categorys = categoryService.addCategory(category);
      return ResponseEntity.status(HttpStatus.CREATED).body(categorys);
  }

  @PutMapping("/update")
  public ResponseEntity<Category> updateCatergory(@RequestBody Category category){
      Category categorys = categoryService.updateCategory(category);
      if(category!=null){
          return ResponseEntity.ok(category);
      }
      else{
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
  }

  @GetMapping("/get")
    public ResponseEntity<Set<Category>> getCatergory(@PathVariable Long categoryId){
        Set<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/get/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Long categoryId){
      Category categories = categoryService.getCategory(categoryId);
      if(categories!=null){
          return ResponseEntity.ok(categories);
      }
      else{
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCategory(Long categoryId){
      categoryService.deleteCategory(categoryId);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
