package com.gumtree.addressbook.dao;

import com.gumtree.addressbook.domain.AddressBookEntry;

import java.util.Set;

public interface AddressBookDao
{
    Set<AddressBookEntry> findAll();
}
