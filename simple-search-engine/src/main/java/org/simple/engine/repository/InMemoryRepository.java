/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
public class InMemoryRepository implements Repository {

    private Map<String, Document> documentByKey;
    private Map<String, Set<String>> keysByToken;

    public InMemoryRepository() {
        documentByKey = new HashMap<>();
        keysByToken = new HashMap<>();
    }

    @Override
    public synchronized void put(String key, Document document) {
        documentByKey.put(key, document);
        makeIndex(key, document);
    }

    private void makeIndex(String key, Document document) {
        StringTokenizer st = new StringTokenizer(document.getContent());
        while (st.hasMoreElements()) {
            String token = st.nextElement().toString();
            if (!keysByToken.containsKey(token)) {
                keysByToken.put(token, new HashSet());
            }
            keysByToken.get(token).add(key);
        }
    }

    @Override
    public Document get(String key) {
        return documentByKey.get(key);
    }

    @Override
    public Collection<Document> getDocumentsByTokens(List<String> tokens) {
        Set indexKeys = keysByToken.entrySet().stream().
                filter(entry -> tokens.contains(entry.getKey())).
                map(entry -> entry.getValue()).flatMap(list -> list.stream()).collect(Collectors.toSet());
        return documentByKey.entrySet().stream().filter(entry -> indexKeys.contains(entry.getKey())).map(entry -> entry.getValue()).collect(Collectors.toSet());
    }

}
