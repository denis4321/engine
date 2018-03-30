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
public interface ContentValidator {

    public boolean isValid(String key);

    public boolean isValid(Document document);

    public boolean isValid(List<String> tokens);

}
