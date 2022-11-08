package ru.rtu_mirea.apipractice5.controller;

import ru.rtu_mirea.apipractice5.entity.Contact;
import ru.rtu_mirea.apipractice5.repository.ContactRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactRepo contactRepo;

    public ContactController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping
    private List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @PostMapping
    private Contact addContact(@RequestBody Contact contact) {
        return contactRepo.save(contact);
    }

    @DeleteMapping
    private ResponseEntity<?> deleteAllContacts() {
        contactRepo.deleteAll();
        return ResponseEntity.ok("All contacts deleted");
    }


    @GetMapping("/{id}")
    private Contact getContactById(@PathVariable Long id) {
        return contactRepo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteContactById(@PathVariable Long id) {
        contactRepo.deleteById(id);
        return ResponseEntity.ok("Contact " + id + " deleted");
    }

    @PatchMapping("/{id}")
    private ResponseEntity<?> updateContactById(@PathVariable Long id, @RequestBody Contact contact) {
        Contact contactFromDb = contactRepo.findById(id).orElse(null);
        if (contactFromDb != null) {
            contactFromDb.setUsername(contact.getUsername());
            contactFromDb.setEmail(contact.getEmail());
            contactFromDb.setPhone(contact.getPhone());
            contactFromDb.setHomePhone(contact.getHomePhone());
            contactRepo.save(contactFromDb);
            return ResponseEntity.ok("Contact " + id + " updated");
        }
        else {
            return ResponseEntity.ok("Patch fail");
        }
    }
}
