/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simple.engine.service.endpoint;

import java.util.Collection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import org.simple.engine.core.Engine;
import org.simple.engine.core.EngineImpl;
import org.simple.engine.model.Document;

/**
 *
 * @author Denis
 */
@WebService(name = "Server")
public class ServerStarter {

    private Engine engine;

    public ServerStarter() {
        engine = new EngineImpl();
    }

    @WebMethod
    public void put(String key, Document document) {
        engine.put(key, document);
    }

    @WebMethod
    public Document get(String key) {
        return engine.get(key);
    }

    @WebMethod
    public Collection<Document> getDocumentsByTokens(List<String> tokens) {
        return engine.getDocumentsByTokens(tokens);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8083/engine", new ServerStarter());
        System.out.println("-----------SERVER STARTED-----------------------");
        System.out.println("-----------http://127.0.0.1:8083/engine?WSDL-----------------------");
    }

}
