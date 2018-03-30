/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.validator;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.simple.engine.model.Document;
import java.util.List;

/**
 *
 * @author Denis
 */
public class SimpleContentValidatorTest {

    private SimpleContentValidator validator;

    @Before
    public void init() {
        validator = new SimpleContentValidator();
    }

    @Test
    public void keyTest() {
        String key = null;
        assertFalse(validator.isValid(key));
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(" "));
        assertTrue(validator.isValid("key"));
    }

    @Test
    public void documentTest() {
        Document document = null;
        assertFalse(validator.isValid(document));
        document = new Document();
        assertFalse(validator.isValid(document));
        document.setContent("content");
        assertTrue(validator.isValid(document));
    }

    @Test
    public void tokensTest() {
        List<String> tokens = null;
        assertFalse(validator.isValid(tokens));
        tokens = new ArrayList();
        assertFalse(validator.isValid(tokens));
        tokens.add("a");
        assertTrue(validator.isValid(tokens));
        tokens.add("");
        assertFalse(validator.isValid(tokens));
        tokens.clear();
        tokens.add(" ");
        assertFalse(validator.isValid(tokens));

    }

}
