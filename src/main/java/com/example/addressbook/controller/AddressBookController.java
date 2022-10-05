package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {


     //@Autowired annotation act as a dependency injection we can inject object of another class

    @Autowired
    IAddressBookService service;


     // Ability to display welcome message

    @GetMapping("")
    public String getMessage() {
        return "Welcome to SpringBoot AddressBook Application";
    }

    // Ability to get all address book data

    @GetMapping("/get")
    public ResponseEntity<String> getAllData() {
        List<AddressBook> listOfContacts = service.getListOfAddresses();
        ResponseDTO response = new ResponseDTO("Addresbook :", listOfContacts);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    // Create api call to save data to database

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> postData(@RequestBody @Valid AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.saveAddress(addressBookDTO);
        ResponseDTO response = new ResponseDTO("New Contact Added in Addressbook : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    //Ability to get person data by id

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> getAddressById(@PathVariable Integer id) {
        ResponseDTO response = new ResponseDTO("Addressbook of given id: ", service.getAddressbyId(id));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //Ability to update address book person data for particular id

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id, @RequestBody @Valid AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.updateDateById(id, addressBookDTO);
        ResponseDTO response = new ResponseDTO("Address-book updated : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    // Ability to delete person data for particular id

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.OK);
    }
}