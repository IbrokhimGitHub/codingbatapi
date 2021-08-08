package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Category;
import uz.pdp.online.codingbatapi.entity.Language;
import uz.pdp.online.codingbatapi.payload.CategoryDto;
import uz.pdp.online.codingbatapi.payload.CategoryResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.repository.CategoryRepository;
import uz.pdp.online.codingbatapi.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LanguageRepository languageRepository;
    public CategoryResult getOne(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            return new CategoryResult(new Category(),false);
        }
        return new CategoryResult(optionalCategory.get(),true);
    }
    public List<Category> getAll(){
        List<Category> all = categoryRepository.findAll();
        return all;
    }
    public Result delete(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            return new Result("cant find such category",false);
        }
        categoryRepository.deleteById(id);
        return new Result("category with id = "+id+" deleted",true);
    }
    public Result add(CategoryDto categoryDto){
        Optional<Language> optionalLanguage = languageRepository.findById(categoryDto.getLanguageId());
        if (!optionalLanguage.isPresent()) {
            return new Result("cant find such language",false);
        }
        boolean existsByName = categoryRepository.existsByName(categoryDto.getName());
        if (existsByName){
            return new Result("such category already exist",false);
        }
        Category category=new Category();
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        category.setNumberOfStars(categoryDto.getNumberOfStars());
        category.setLanguage(optionalLanguage.get());
        categoryRepository.save(category);
        return new Result("category saved successfully",true);
    }
    public Result edit(Integer id,CategoryDto categoryDto){
        Optional<Language> optionalLanguage = languageRepository.findById(categoryDto.getLanguageId());
        if (!optionalLanguage.isPresent()) {
            return new Result("cant find such language",false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            return new Result("cant find such category",false);
        }
        Category category = optionalCategory.get();
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        category.setNumberOfStars(categoryDto.getNumberOfStars());
        category.setLanguage(optionalLanguage.get());
        categoryRepository.save(category);
        return new Result("category edited successfully",true);

    }
}

