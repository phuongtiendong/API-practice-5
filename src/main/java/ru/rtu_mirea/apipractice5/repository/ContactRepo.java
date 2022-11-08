package ru.rtu_mirea.apipractice5.repository;

import ru.rtu_mirea.apipractice5.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
