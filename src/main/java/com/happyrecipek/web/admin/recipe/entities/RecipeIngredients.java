package com.happyrecipek.web.admin.recipe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredients {

	@Id
	@Column(name="RECIPE_INGREDIENTS_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="레시피 재료 순번")
	private int recipeIngredientsSeq;
	
}
