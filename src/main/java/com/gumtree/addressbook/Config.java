package com.gumtree.addressbook;

import com.gumtree.addressbook.dao.AddressBookDao;
import com.gumtree.addressbook.resolver.Resolver;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;

public class Config
{
    private Properties properties;
    private Map<String, Resolver> resolvers;

    public Config(String configFile, String questionFile)
    {

    }

    public List<String[]> getQuestions()
    {
        return null;
    }

    public Map<String, Resolver> getResolvers()
    {
        return null;
    }

    public AddressBookDao getAddressBookDao()
    {
        return null;
    }

    public static List<String> readFile(String filename, Object c1ass)
    {
        URL url = c1ass.getClass()
                .getClassLoader()
                .getResource(filename);
        Path data = Paths.get(url.getPath());
        try
        {
            return Files.readAllLines(data);
        }
        catch (Exception e)
        {
            throw new RuntimeException(format("Error reading file: %s", filename), e);
        }
    }
}
