//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.28 at 11:13:34 AM CET 
//


package pl.edu.agh.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rulevariablereftype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rulevariablereftype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}objectattributes"/>
 *       &lt;attribute name="rulevariableref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rulevariablereftype")
public class Rulevariablereftype {

    @XmlAttribute(name = "rulevariableref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object rulevariableref;
    @XmlAttribute(name = "attributeref")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object attributeref;
    @XmlAttribute(name = "index")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger index;

    /**
     * Gets the value of the rulevariableref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRulevariableref() {
        return rulevariableref;
    }

    /**
     * Sets the value of the rulevariableref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRulevariableref(Object value) {
        this.rulevariableref = value;
    }

    /**
     * Gets the value of the attributeref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAttributeref() {
        return attributeref;
    }

    /**
     * Sets the value of the attributeref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAttributeref(Object value) {
        this.attributeref = value;
    }

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *     
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setIndex(BigInteger value) {
        this.index = value;
    }

}