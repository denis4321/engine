/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.core;

import org.simple.engine.model.Document;
import org.simple.engine.validator.ContentValidator;
import org.simple.engine.repository.Repository;
import java.util.Collection;
import java.util.List;
import org.simple.engine.repository.InMemoryRepository;
import org.simple.engine.validator.SimpleContentValidator;

/**
 *
 * @author Denis
 */
public class EngineImpl implements Engine {

    private Repository repository;
    private ContentValidator validator;

    public EngineImpl() {
        repository = new InMemoryRepository();
        validator = new SimpleContentValidator();
    }

    @Override
    public void put(String key, Document document) {
        if (!validator.isValid(document)) {
            throw new RuntimeException("Invalid Document: " + document);
        }
        if (!validator.isValid(key)) {
            throw new RuntimeException("Invalid key: " + key);
        }
        repository.put(key, document);
    }

    @Override
    public Document get(String key) {
        if (!validator.isValid(key)) {
            throw new RuntimeException("Invalid key: " + key);
        }
        return repository.get(key);
    }

    @Override
    public Collection<Document> getDocumentsByTokens(List<String> tokens) {
        if (!validator.isValid(tokens)) {
            throw new RuntimeException("Invalid tokens: " + tokens);
        }
        return repository.getDocumentsByTokens(tokens);
    }

}
