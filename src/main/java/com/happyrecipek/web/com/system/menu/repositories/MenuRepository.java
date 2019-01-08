package com.happyrecipek.web.com.system.menu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.system.menu.repositories.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
