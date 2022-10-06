package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

// Created IAddressBookService interface to achieve abstraction
public interface IAddressBookService {

    public AddressBook saveAddress(AddressBookDTO addressBookDTO);

    public List<AddressBook> getListOfAddresses();

    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO);

    public void deleteContact(Integer id);

    Object getAddressbyId(Integer id);
    public Optional<AddressBook> getDataById(Integer id);

    public List<AddressBook> getDataByCity(String city);
    public List<AddressBook> getDataByFirstName(String firstName);
}
