/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modi2018.busywaiting.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.Addressing;
import modi2018.busywaiting.common.ACKMessage;
import modi2018.busywaiting.common.ErrorMessageException;
import modi2018.busywaiting.common.ProcessingStatus;
import modi2018.busywaiting.common.MResponseType;
import modi2018.busywaiting.common.MType;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.OutInterceptors;

/**
 *
 * @author Francesco
 */
@WebService(targetNamespace = "http://amministrazioneesempio.it/nomeinterfacciaservizio")
@OutInterceptors(interceptors="modi2018.busywaiting.server.Interceptor")
public interface SOAPBusyWaiting {
    @WebMethod(operationName="MRequest")
    public ProcessingStatus PushMessage(@WebParam(name = "M") MType M,
            @WebParam(name="X-CorrelationID", header=true, mode=WebParam.Mode.OUT) Holder<String> correlationID) throws ErrorMessageException;
    
    @WebMethod(operationName="MProcessingStatus")
    public ProcessingStatus ResponseMessageById(@WebParam(name="X-CorrelationID", header=true) String correlationID) throws ErrorMessageException;
    
    @WebMethod(operationName="MResponse")
    public MResponseType ResponseById(@WebParam(name="X-CorrelationID", header=true) String correlationID) throws ErrorMessageException;
}
