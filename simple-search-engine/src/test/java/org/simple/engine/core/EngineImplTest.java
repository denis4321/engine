/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
public class EngineImplTest {

    private EngineImpl engineImpl;

    @Before
    public void init() {
        engineImpl = new EngineImpl();
    }

    @Test
    public void getPutTest() {
        assertNull(engineImpl.get("a"));
        assertTrue(engineImpl.getDocumentsByTokens(Arrays.asList("a", "b", "c")).isEmpty());

        Document a = new Document();
        a.setContent("this is a");
        engineImpl.put("a", a);

        Document b = new Document();
        b.setContent("this is b");
        engineImpl.put("b", b);

        Document c = new Document();
        c.setContent("it is good");
        engineImpl.put("c", c);

        assertNotNull(engineImpl.get("a"));
        assertNotNull(engineImpl.get("b"));
        assertNotNull(engineImpl.get("c"));

    }

    @Test
    public void getDocumentsByTokensTest() {
        Document a = new Document();
        a.setContent("this is a");
        engineImpl.put("a", a);

        Document b = new Document();
        b.setContent("this is b");
        engineImpl.put("b", b);

        Document c = new Document();
        c.setContent("it is good");
        engineImpl.put("c", c);
        List<String> tokens = new ArrayList();
        tokens.add("a");
        tokens.add("b");
        tokens.add("good");
        Collection<Document> documents = engineImpl.getDocumentsByTokens(tokens);
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

    @Test(expected = RuntimeException.class)
    public void incorrectRequests() {
        try {
            engineImpl.get("");
        } catch (RuntimeException ex) {
            fail("Empty key was not fired");
        }
        try {
            engineImpl.get(" ");
        } catch (RuntimeException ex) {
            fail("Space key was not fired");
        }
        Document document = null;
        try {
            engineImpl.put("", document);
        } catch (RuntimeException ex) {
            fail("Empty key was not fired");
        }

        try {
            engineImpl.put(" ", document);
        } catch (RuntimeException ex) {
            fail("Space key was not fired");
        }
        try {
            engineImpl.put(null, document);
        } catch (RuntimeException ex) {
            fail("Space key was not fired");
        }
        try {
            engineImpl.put("a", document);
        } catch (RuntimeException ex) {
            fail("Space key was not fired");
        }
        try {
            document = new Document();
        } catch (RuntimeException ex) {
            fail("Space key was not fired");
        }
        try {
            engineImpl.put("a", document);
        } catch (RuntimeException ex) {
            fail("Empty documentwas not fired");
        }
    }

    @Test(expected = RuntimeException.class)
    public void incorrectNullRequest() {
        engineImpl.get(null);
    }
}
