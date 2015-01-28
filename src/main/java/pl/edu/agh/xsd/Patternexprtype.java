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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patternexprtype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patternexprtype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="patternexpr" type="{}patternexprtype" minOccurs="0"/>
 *         &lt;element name="logicalexpr" type="{}logicalexprtype"/>
 *       &lt;/sequence>
 *       &lt;attribute name="factsource" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="allfacts"/>
 *             &lt;enumeration value="pattern"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="facttype" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="rulevariableref" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patternexprtype", propOrder = {
    "patternexpr",
    "logicalexpr"
})
public class Patternexprtype {

    protected Patternexprtype patternexpr;
    @XmlElement(required = true)
    protected Logicalexprtype logicalexpr;
    @XmlAttribute(name = "factsource", required = true)
    protected String factsource;
    @XmlAttribute(name = "facttype", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object facttype;
    @XmlAttribute(name = "rulevariableref")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object rulevariableref;

    /**
     * Gets the value of the patternexpr property.
     * 
     * @return
     *     possible object is
     *     {@link pl.edu.agh.xsd.Patternexprtype }
     *     
     */
    public Patternexprtype getPatternexpr() {
        return patternexpr;
    }

    /**
     * Sets the value of the patternexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link pl.edu.agh.xsd.Patternexprtype }
     *     
     */
    public void setPatternexpr(Patternexprtype value) {
        this.patternexpr = value;
    }

    /**
     * Gets the value of the logicalexpr property.
     * 
     * @return
     *     possible object is
     *     {@link pl.edu.agh.xsd.Logicalexprtype }
     *     
     */
    public Logicalexprtype getLogicalexpr() {
        return logicalexpr;
    }

    /**
     * Sets the value of the logicalexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link pl.edu.agh.xsd.Logicalexprtype }
     *     
     */
    public void setLogicalexpr(Logicalexprtype value) {
        this.logicalexpr = value;
    }

    /**
     * Gets the value of the factsource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactsource() {
        return factsource;
    }

    /**
     * Sets the value of the factsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactsource(String value) {
        this.factsource = value;
    }

    /**
     * Gets the value of the facttype property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFacttype() {
        return facttype;
    }

    /**
     * Sets the value of the facttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFacttype(Object value) {
        this.facttype = value;
    }

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
