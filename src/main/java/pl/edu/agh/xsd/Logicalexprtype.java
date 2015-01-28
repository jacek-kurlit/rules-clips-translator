//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.28 at 11:13:34 AM CET 
//


package pl.edu.agh.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for logicalexprtype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="logicalexprtype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logicalexpr" type="{}logicalexprtype" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="relationexpr" type="{}relationexprtype" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="operator" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="not"/>
 *             &lt;enumeration value="or"/>
 *             &lt;enumeration value="and"/>
 *             &lt;enumeration value="none"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "logicalexprtype", propOrder = {
    "logicalexpr",
    "relationexpr"
})
public class Logicalexprtype {

    protected List<Logicalexprtype> logicalexpr;
    protected List<Relationexprtype> relationexpr;
    @XmlAttribute(name = "operator", required = true)
    protected String operator;

    /**
     * Gets the value of the logicalexpr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalexpr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalexpr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link pl.edu.agh.xsd.Logicalexprtype }
     * 
     * 
     */
    public List<Logicalexprtype> getLogicalexpr() {
        if (logicalexpr == null) {
            logicalexpr = new ArrayList<Logicalexprtype>();
        }
        return this.logicalexpr;
    }

    /**
     * Gets the value of the relationexpr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationexpr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationexpr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Relationexprtype }
     * 
     * 
     */
    public List<Relationexprtype> getRelationexpr() {
        if (relationexpr == null) {
            relationexpr = new ArrayList<Relationexprtype>();
        }
        return this.relationexpr;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

}
