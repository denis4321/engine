/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engine.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.xml.ws.WebServiceException;
import org.simple.engine.service.endpoint.Document;
import org.simple.engine.service.endpoint.Server;
import org.simple.engine.service.endpoint.ServerStarterService;

/**
 *
 * @author Denis
 */
public class ClientStarter {

    public static void main(String[] args) {
        System.out.println("---------------Making SOAP call-------------");
        ServerStarterService starterService = null;
        if (args.length == 0) {
            starterService = new ServerStarterService();
        } else {
            URL url = null;
            try {
                url = new URL(args[0]);
                starterService = new ServerStarterService(url);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        Server server = starterService.getServerPort();
        String content = "Test content";
        Document document = new Document();
        document.setContent(content);
        server.put("data1", document);

        Document document2 = new Document();
        document2.setContent("Application data example");
        server.put("data2", document2);

        Document result = server.get("data1");
        System.out.println("get('data1')=" + result.getContent());
        Document result2 = server.get("data2");
        System.out.println("get('data2')=" + result2.getContent());
        System.out.println("--------------------------------------------------------");
        List<Document> doculemnts = server.getDocumentsByTokens(Arrays.asList("Test", "data"));
        for (Document item : doculemnts) {
            System.out.println(item.getContent());
        }
        System.out.println("--------------------------------------------------------");

        Document a = new Document();
        a.setContent("this is a");
        server.put("a", a);
        Document b = new Document();
        b.setContent("this is b");
        server.put("b", b);

        Document c = new Document();
        c.setContent("it is good");
        server.put("c", c);

        System.out.println(server.get("a").getContent());
        System.out.println(server.get("b").getContent());
        System.out.println(server.get("c").getContent());
        System.out.println("--------------------------------");
        Collection<Document> documents = server.getDocumentsByTokens(Arrays.asList("a", "b", "good"));
        for (Document item : documents) {
            System.out.println(item.getContent());
        }
    }

}
