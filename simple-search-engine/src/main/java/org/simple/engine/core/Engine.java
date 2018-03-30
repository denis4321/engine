/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.core;

import org.simple.engine.model.Document;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface Engine {

    public void put(String key, Document document);

    public Document get(String key);

    public Collection<Document> getDocumentsByTokens(List<String> tokens);

}
