//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.28 at 11:13:34 AM CET 
//


package pl.edu.agh.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retractexprtype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retractexprtype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="rulevariableref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retractexprtype")
public class Retractexprtype {

    @XmlAttribute(name = "rulevariableref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object rulevariableref;

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

}
