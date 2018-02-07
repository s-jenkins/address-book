package com.gumtree.addressbook;

import com.gumtree.addressbook.dao.AddressBookDao;
import com.gumtree.addressbook.dao.AddressBookFlatFileDao;
import com.gumtree.addressbook.resolver.Resolver;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

public class ConfigTest
{
    private Config config = new Config("test-app.properties", "test-questions");

    @Test
    public void getQuestions() throws Exception
    {
        List<String[]> questions = config.getQuestions();

        assertEquals("QA", questions.get(0)[0]);
        assertEquals(5, questions.get(0).length);
        assertEquals("Question #1", questions.get(0)[1]);
        assertEquals("key1", questions.get(0)[2]);
        assertEquals("P1", questions.get(0)[3]);
        assertEquals("P2", questions.get(0)[4]);

        assertEquals("QB", questions.get(1)[0]);
        assertEquals(4, questions.get(1).length);
        assertEquals("Question #2", questions.get(1)[1]);
        assertEquals("key2", questions.get(1)[2]);
        assertEquals("P3", questions.get(1)[3]);

        assertEquals("QC", questions.get(2)[0]);
        assertEquals(3, questions.get(2).length);
        assertEquals("Question #3", questions.get(2)[1]);
        assertEquals("key3", questions.get(2)[2]);
    }

    @Test
    public void getResolvers() throws Exception
    {
        Map<String, Resolver> map = config.getResolvers();
        assertEquals(map.size(), 2);
        assertEquals(map.get("sex.counter").getClass().getSimpleName(), "SexCounter");
    }

    @Test
    public void getAddressBookDao() throws Exception
    {
        AddressBookDao dao = config.getAddressBookDao();
        assertTrue(dao instanceof AddressBookFlatFileDao);
    }

    @Test
    public void testGetProperties()
    {
        Properties props = config.getProperties();
        assertEquals(5, props.size());

        assertEquals( props.getProperty("addressbookflatfiledao.filename"), "AddressBook");
        assertEquals( props.getProperty("resolver.sex.counter"), "com.gumtree.addressbook.resolver.SexCounter");
        assertEquals( props.getProperty("addressbookflatfiledao.assume20thCentuaryAfter"), "17");
    }
}