package com.example.addressbook.repository;


import com.example.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

// Queary to Find data by City
    @Query(value="select * from address_book where city= :city",nativeQuery = true)
    List<AddressBook> findByCity(String city);

    //queary to find data by firstName
    @Query(value = "select * from address_book where first_name= :firstName",nativeQuery = true)
    List<AddressBook> findByFirstName(String firstName);
}
