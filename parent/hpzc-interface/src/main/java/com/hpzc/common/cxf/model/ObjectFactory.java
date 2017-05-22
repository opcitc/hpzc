
package com.hpzc.common.cxf.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hpzc.common.cxf.model package. 
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

    private final static QName _MTTMSECCFITMSYXNO_QNAME = new QName("urn:sinopec:ecc:fi:tmsno:fx", "MT_TMS_ECC_FI_TMSYXNO");
    private final static QName _MTTMSECCFITMSYXNOResponse_QNAME = new QName("urn:sinopec:ecc:fi:tmsno:fx", "MT_TMS_ECC_FI_TMSYXNOResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hpzc.common.cxf.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MTTMSECCFITMSYXNO }
     * 
     */
    public MTTMSECCFITMSYXNO createMTTMSECCFITMSYXNO() {
        return new MTTMSECCFITMSYXNO();
    }

    /**
     * Create an instance of {@link MTTMSECCFITMSYXNOResponse }
     * 
     */
    public MTTMSECCFITMSYXNOResponse createMTTMSECCFITMSYXNOResponse() {
        return new MTTMSECCFITMSYXNOResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MTTMSECCFITMSYXNO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sinopec:ecc:fi:tmsno:fx", name = "MT_TMS_ECC_FI_TMSYXNO")
    public JAXBElement<MTTMSECCFITMSYXNO> createMTTMSECCFITMSYXNO(MTTMSECCFITMSYXNO value) {
        return new JAXBElement<MTTMSECCFITMSYXNO>(_MTTMSECCFITMSYXNO_QNAME, MTTMSECCFITMSYXNO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MTTMSECCFITMSYXNOResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sinopec:ecc:fi:tmsno:fx", name = "MT_TMS_ECC_FI_TMSYXNOResponse")
    public JAXBElement<MTTMSECCFITMSYXNOResponse> createMTTMSECCFITMSYXNOResponse(MTTMSECCFITMSYXNOResponse value) {
        return new JAXBElement<MTTMSECCFITMSYXNOResponse>(_MTTMSECCFITMSYXNOResponse_QNAME, MTTMSECCFITMSYXNOResponse.class, null, value);
    }

}
