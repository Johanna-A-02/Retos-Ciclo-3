package com.reto.service.impl;

import com.reto.model.Category;
import com.reto.repository.CategoryRepository;
import com.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory(){
        List<Category> response = categoryRepository.findAll();
        return response;
    }

    @Override
    public Category postCategory(Category category) {

        if(category.getId() == null){
            categoryRepository.save(category);
        }else{
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
            if(categoryOptional.isEmpty()){
                category = categoryRepository.save(category);
            }else{
                category = categoryOptional.get();
            }
        }

        return category;
    }
    @Override
    public Category putCategory(Category category){
        if(category.getId() != null){
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
            if(categoryOptional.isPresent()){
                Category categoryUpdate = categoryOptional.get();
                categoryUpdate.setName(category.getName() != null ? category.getName(): categoryUpdate.getName());
                categoryUpdate.setDescription(category.getDescription() != null ? category.getDescription(): categoryUpdate.getDescription());

                //categoryUpdate.setCategory(category.getCategory() != null ? category.getCategory(): categoryUpdate.getCategory());
                //categoryUpdate.setMessages(category.getMessages() != null ? category.getMessages(): categoryUpdate.getMessages());
                //categoryUpdate.setReservations(category.getReservations() != null ? category.getReservations(): categoryUpdate.getReservations());


                category = categoryRepository.save(categoryUpdate);
            }
        }
        return category;
    }

    @Override
    public Optional<Category> getCategoryById(Integer idCategory){
        return categoryRepository.findById(idCategory);
    }

    @Override
    public boolean deleteCategory(Integer idCategory){
        Boolean flag = categoryRepository.findById(idCategory).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);

        return flag;
    }
}
