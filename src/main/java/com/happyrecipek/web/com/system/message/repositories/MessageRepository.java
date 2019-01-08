package com.happyrecipek.web.com.system.message.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.system.message.repositories.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
