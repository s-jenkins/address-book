package com.gumtree.addressbook.resolver;

import com.gumtree.addressbook.domain.AddressBookEntry;

import java.util.List;

public interface Resolver
{
    String answer(List<AddressBookEntry> data, String... parms);
}
