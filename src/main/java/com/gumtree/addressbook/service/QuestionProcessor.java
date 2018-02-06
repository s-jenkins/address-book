package com.gumtree.addressbook.service;

import com.gumtree.addressbook.resolver.Resolver;

public interface QuestionProcessor
{
    String process(String question, Resolver resolver, String... parms);
}
