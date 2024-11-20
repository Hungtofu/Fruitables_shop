package Fruitables.shop.service;

import Fruitables.shop.dto.CategoryDTO;
import Fruitables.shop.entity.Category;
import Fruitables.shop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository cateRepo;

    public CategoryService(CategoryRepository cateRepo) {
        this.cateRepo = cateRepo;
    }

    public List<CategoryDTO> getAllCategory(){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for(Category c : this.cateRepo.findAll()){
            categoryDTOList.add(new CategoryDTO(c));
        }
        return categoryDTOList;
    }

}
