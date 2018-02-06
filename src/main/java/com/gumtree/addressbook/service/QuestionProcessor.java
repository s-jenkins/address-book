package com.gumtree.addressbook.service;

import com.gumtree.addressbook.domain.AddressBookEntry;
import com.gumtree.addressbook.resolver.Resolver;

import java.util.List;
import java.util.Map;

public class QuestionProcessor
{
    private Map<String, Resolver> resolvers;
    String process(String question, String resolverKey, List<AddressBookEntry> data, String... parms)
    {
        Resolver resolver = resolvers.get(resolverKey);
        return resolver.answer(data, parms);
    }

    public void setResolvers(Map<String, Resolver> resolvers)
    {
        this.resolvers = resolvers;
    }
}
