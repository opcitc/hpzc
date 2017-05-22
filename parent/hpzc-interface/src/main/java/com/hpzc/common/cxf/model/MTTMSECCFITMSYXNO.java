
package com.hpzc.common.cxf.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MT_TMS_ECC_FI_TMSYXNO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MT_TMS_ECC_FI_TMSYXNO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TmsYxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="YWRQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MT_TMS_ECC_FI_TMSYXNO", propOrder = {
    "tmsYxNo",
    "code",
    "ywrq"
})
public class MTTMSECCFITMSYXNO {

    @XmlElement(name = "TmsYxNo")
    protected String tmsYxNo;
    @XmlElement(name = "CODE")
    protected String code;
    @XmlElement(name = "YWRQ")
    protected String ywrq;

    /**
     * 获取tmsYxNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmsYxNo() {
        return tmsYxNo;
    }

    /**
     * 设置tmsYxNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmsYxNo(String value) {
        this.tmsYxNo = value;
    }

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODE() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODE(String value) {
        this.code = value;
    }

    /**
     * 获取ywrq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYWRQ() {
        return ywrq;
    }

    /**
     * 设置ywrq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYWRQ(String value) {
        this.ywrq = value;
    }

}
