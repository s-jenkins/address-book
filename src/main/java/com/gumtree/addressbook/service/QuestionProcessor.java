package com.gumtree.addressbook.service;

import com.gumtree.addressbook.domain.AddressBookEntry;
import com.gumtree.addressbook.resolver.Resolver;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class QuestionProcessor
{
    private Map<String, Resolver> resolvers;
    String process(String question, String resolverKey, List<AddressBookEntry> data, String... parms)
    {
        Resolver resolver = resolvers.get(resolverKey);
        if (resolver == null) {
            return format("I cannot answer this question - no resolver found for key: %s", resolverKey);
        }
        return resolver.answer(data, parms);
    }

    public void setResolvers(Map<String, Resolver> resolvers)
    {
        this.resolvers = resolvers;
    }
}
