package com.gumtree.addressbook.service;

public interface QuestionProcessor
{
    String process(String question, Resolver resolver, String... parms);
}
