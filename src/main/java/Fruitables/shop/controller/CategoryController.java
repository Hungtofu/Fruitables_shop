package Fruitables.shop.controller;

import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService cateService;

    public CategoryController(CategoryService cateService) {
        this.cateService = cateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<RestResponse<Object>> getAll(){
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(cateService.getAllCategory());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
