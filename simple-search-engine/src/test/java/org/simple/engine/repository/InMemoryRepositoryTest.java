/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
public class InMemoryRepositoryTest {

    private Repository repository;

    @Before
    public void init() {
        repository = new InMemoryRepository();
    }

    @Test
    public void getPutTest() {
        assertNull(repository.get("a"));
        assertTrue(repository.getDocumentsByTokens(Arrays.asList("a", "b", "c")).isEmpty());

        Document a = new Document();
        a.setContent("this is a");
        repository.put("a", a);

        Document b = new Document();
        b.setContent("this is b");
        repository.put("b", b);

        Document c = new Document();
        c.setContent("it is good");
        repository.put("c", c);

        assertNotNull(repository.get("a"));
        assertNotNull(repository.get("b"));
        assertNotNull(repository.get("c"));

    }

    @Test
    public void getDocumentsByTokensTest() {
        Document a = new Document();
        a.setContent("this is a");
        repository.put("a", a);

        Document b = new Document();
        b.setContent("this is b");
        repository.put("b", b);

        Document c = new Document();
        c.setContent("it is good");
        repository.put("c", c);
        List<String> tokens = new ArrayList();
        tokens.add("a");
        tokens.add("b");
        tokens.add("good");
        Collection<Document> documents = repository.getDocumentsByTokens(tokens);
        assertTrue(documents.size() + "", documents.size() == 3);
        List<String> results = new ArrayList();
        tokens.add("this is a");
        tokens.add("this is b");
        tokens.add("it is good");
        for (Document document : documents) {
            results.remove(document.getContent());
        }
        assertTrue(results.isEmpty());
    }

}
