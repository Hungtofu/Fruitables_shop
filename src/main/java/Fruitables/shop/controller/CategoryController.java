package Fruitables.shop.controller;

import Fruitables.shop.dto.CategoryDTO;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService cateService;

    public CategoryController(CategoryService cateService) {
        this.cateService = cateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<CategoryDTO> categoryDTOList = cateService.getAllCategory();
        return ResponseEntity.status(HttpStatus.OK.value()).body(categoryDTOList);
    }

}
