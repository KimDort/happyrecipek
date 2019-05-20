package com.happyrecipek.web.admin.recipe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.admin.recipe.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}
