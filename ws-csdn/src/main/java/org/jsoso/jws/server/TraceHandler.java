package org.jsoso.jws.server;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Janita on 2017-03-24 21:58
 */
public class TraceHandler implements SOAPHandler<SOAPMessageContext>{


    @Override
    public void close(MessageContext context) {
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        // 判断消息是请求还是响应
        Boolean output = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        boolean result = false;

        SOAPMessage message = context.getMessage();

        //如果是请求，则执行校验
        if(!output){
            result = validate(message);

            if(!result){
                validateFail(message);
            }
        }

        System.out.println(output ? "服务端响应：" : "服务端接收：");
        try {
            message.writeTo(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\r\n");

        return result;
    }

    /**
     * 授权校验失败，在SOAPBody中添加SOAPFault
     * @param message
     */
    private void validateFail(SOAPMessage message) {
        try {
            SOAPEnvelope envelop = message.getSOAPPart().getEnvelope();

            envelop.getHeader().detachNode();
            envelop.addHeader();

            envelop.getBody().detachNode();
            SOAPBody body = envelop.addBody();

            SOAPFault fault = body.getFault();

            if (fault == null) {
                fault = body.addFault();
            }

            fault.setFaultString("授权校验失败！");

            message.saveChanges();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    /**
     * 授权校验
     * @param message
     * @return 校验成功返回true，校验失败返回false
     */
    private boolean validate(SOAPMessage message){
        boolean result = false;

        try {
            SOAPEnvelope envelop = message.getSOAPPart().getEnvelope();
            SOAPHeader header = envelop.getHeader();

            if(header != null){
                Iterator iterator = header.getChildElements(new QName("http://www.tmp.com/auth", "auth"));
                SOAPElement auth = null;

                if(iterator.hasNext()){
                    //获取auth
                    auth = (SOAPElement)iterator.next();

                    //获取name
                    Iterator it = auth.getChildElements(new QName("http://www.tmp.com/auth", "name"));
                    SOAPElement name = null;
                    if(it.hasNext()){
                        name = (SOAPElement)it.next();
                    }

                    //获取password
                    it = auth.getChildElements(new QName("http://www.tmp.com/auth", "password"));
                    SOAPElement password = null;
                    if(it.hasNext()){
                        password = (SOAPElement)it.next();
                    }

                    //判断name和password是否符合要求
                    if(name != null && password != null && "admin".equals(name.getValue()) && "admin".equals(password.getValue())){
                        result = true;
                    }
                }
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}
