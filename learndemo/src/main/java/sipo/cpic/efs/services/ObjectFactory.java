
package sipo.cpic.efs.services;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sipo.cpic.efs.services package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sipo.cpic.efs.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveFileMax }
     * 
     */
    public RetrieveFileMax createRetrieveFileMax() {
        return new RetrieveFileMax();
    }

    /**
     * Create an instance of {@link RetrieveFileResponse }
     * 
     */
    public RetrieveFileResponse createRetrieveFileResponse() {
        return new RetrieveFileResponse();
    }

    /**
     * Create an instance of {@link RetrieveFile }
     * 
     */
    public RetrieveFile createRetrieveFile() {
        return new RetrieveFile();
    }

    /**
     * Create an instance of {@link RetrieveFileMaxResponse }
     * 
     */
    public RetrieveFileMaxResponse createRetrieveFileMaxResponse() {
        return new RetrieveFileMaxResponse();
    }

}
