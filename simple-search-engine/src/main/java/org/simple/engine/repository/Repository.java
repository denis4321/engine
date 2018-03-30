/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.repository;

import java.util.Collection;
import java.util.List;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
public interface Repository {

    public void put(String key, Document document);

    public Document get(String key);

    public Collection<Document> getDocumentsByTokens(List<String> tokens);

}
