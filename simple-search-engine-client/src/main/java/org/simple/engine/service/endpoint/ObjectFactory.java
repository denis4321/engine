
package org.simple.engine.service.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.simple.engine.service.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Get_QNAME = new QName("http://endpoint.service.engine.simple.org/", "get");
    private final static QName _GetDocumentsByTokens_QNAME = new QName("http://endpoint.service.engine.simple.org/", "getDocumentsByTokens");
    private final static QName _GetResponse_QNAME = new QName("http://endpoint.service.engine.simple.org/", "getResponse");
    private final static QName _PutResponse_QNAME = new QName("http://endpoint.service.engine.simple.org/", "putResponse");
    private final static QName _GetDocumentsByTokensResponse_QNAME = new QName("http://endpoint.service.engine.simple.org/", "getDocumentsByTokensResponse");
    private final static QName _Put_QNAME = new QName("http://endpoint.service.engine.simple.org/", "put");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.simple.engine.service.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocumentsByTokensResponse }
     * 
     */
    public GetDocumentsByTokensResponse createGetDocumentsByTokensResponse() {
        return new GetDocumentsByTokensResponse();
    }

    /**
     * Create an instance of {@link PutResponse }
     * 
     */
    public PutResponse createPutResponse() {
        return new PutResponse();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link GetDocumentsByTokens }
     * 
     */
    public GetDocumentsByTokens createGetDocumentsByTokens() {
        return new GetDocumentsByTokens();
    }

    /**
     * Create an instance of {@link Put }
     * 
     */
    public Put createPut() {
        return new Put();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "get")
    public JAXBElement<Get> createGet(Get value) {
        return new JAXBElement<Get>(_Get_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocumentsByTokens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "getDocumentsByTokens")
    public JAXBElement<GetDocumentsByTokens> createGetDocumentsByTokens(GetDocumentsByTokens value) {
        return new JAXBElement<GetDocumentsByTokens>(_GetDocumentsByTokens_QNAME, GetDocumentsByTokens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "getResponse")
    public JAXBElement<GetResponse> createGetResponse(GetResponse value) {
        return new JAXBElement<GetResponse>(_GetResponse_QNAME, GetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "putResponse")
    public JAXBElement<PutResponse> createPutResponse(PutResponse value) {
        return new JAXBElement<PutResponse>(_PutResponse_QNAME, PutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocumentsByTokensResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "getDocumentsByTokensResponse")
    public JAXBElement<GetDocumentsByTokensResponse> createGetDocumentsByTokensResponse(GetDocumentsByTokensResponse value) {
        return new JAXBElement<GetDocumentsByTokensResponse>(_GetDocumentsByTokensResponse_QNAME, GetDocumentsByTokensResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Put }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service.engine.simple.org/", name = "put")
    public JAXBElement<Put> createPut(Put value) {
        return new JAXBElement<Put>(_Put_QNAME, Put.class, null, value);
    }

}
