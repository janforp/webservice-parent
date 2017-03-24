
package org.jsoso.jws.server.wsimportGen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Example", targetNamespace = "http://www.jsoso.com/wstest")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Example {


    /**
     * 
     * @param userName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "sayHello")
    @WebResult(name = "returnWord", partName = "returnWord")
    @Action(input = "sayHello", output = "http://www.jsoso.com/wstest/Example/toSayHelloResponse")
    public String toSayHello(
        @WebParam(name = "userName", partName = "userName")
        String userName);

    /**
     * 
     * @param person
     * @param arg1
     * @return
     *     returns org.jsoso.jws.server.ref.PersonArray
     */
    @WebMethod(action = "sayHello")
    @WebResult(name = "personList", partName = "personList")
    @Action(input = "sayHello", output = "http://www.jsoso.com/wstest/Example/sayHelloResponse")
    public PersonArray sayHello(
        @WebParam(name = "person", partName = "person")
        Person person,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

}