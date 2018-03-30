/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.validator;

import java.util.List;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
public class SimpleContentValidator implements ContentValidator {

    @Override
    public boolean isValid(String key) {
        return !isEmptyOrNull(key);
    }

    @Override
    public boolean isValid(Document document) {
        if (document == null) {
            return false;
        }
        if (document.getContent() == null || document.getContent().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid(List<String> tokens) {
        if (tokens == null) {
            return false;
        }
        if (tokens.isEmpty()) {
            return false;
        }
        for (String token : tokens) {
            if (isEmptyOrNull(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }

}
