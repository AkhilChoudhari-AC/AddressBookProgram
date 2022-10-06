package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    // Autowired  AddressBookRepository class to inject its dependency

    @Autowired
    AddressBookRepository repository;

    //Created method name as saveAddrss which serve controllers api call to save record to repo
    public AddressBook saveAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }

    //Created method name aas getListOfAddresses which serves controllers api call to retrieve all records

    public List<AddressBook> getListOfAddresses() {
        List<AddressBook> list = repository.findAll();
        return list;
    }
    //Created method name as getDataById which serves controllers api call to retrieve record by id

    public Optional<AddressBook> getDataById(Integer id) {
        Optional<AddressBook> newAddressBook = repository.findById(id);
        return newAddressBook;
    }
//    public AddressBook getDataById(Integer id) {
//        Optional<AddressBook> newAddressBook = repository.findById(id);
//
//            return newAddressBook.get();
//        }

    //Created method name as updateDataById which serves controllers api call to update record by id

    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(id, addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }

    // Created method name as deleteContact which serves controllers api call to delete record by id

    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Object getAddressbyId(Integer id) {
        return null;
    }

    public List<AddressBook> getDataByCity(String city){
        List<AddressBook> newAdd = repository.findByCity(city);
        if (newAdd.isEmpty()){
            throw new AddressBookException("City not found");
        }
        return newAdd;
    }

    public List<AddressBook> getDataByFirstName(String firstName){
        List<AddressBook> newAdd = repository.findByFirstName(firstName);
        if (newAdd.isEmpty()){
            throw new AddressBookException("FirstName not found");
        }
        return newAdd;
    }
}
