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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tupletype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tupletype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="set" type="{}settype"/>
 *                   &lt;element name="setexpr" type="{}setexprtype"/>
 *                   &lt;element name="tuple" type="{}tupletype"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tupletype", propOrder = {
    "item"
})
@XmlSeeAlso({
    Objecttype.class
})
public class Tupletype {

    @XmlElement(required = true)
    protected List<Item> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link pl.edu.agh.xsd.Tupletype.Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="set" type="{}settype"/>
     *         &lt;element name="setexpr" type="{}setexprtype"/>
     *         &lt;element name="tuple" type="{}tupletype"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "set",
        "setexpr",
        "tuple"
    })
    public static class Item {

        protected Settype set;
        protected Setexprtype setexpr;
        protected Tupletype tuple;

        /**
         * Gets the value of the set property.
         * 
         * @return
         *     possible object is
         *     {@link pl.edu.agh.xsd.Settype }
         *     
         */
        public Settype getSet() {
            return set;
        }

        /**
         * Sets the value of the set property.
         * 
         * @param value
         *     allowed object is
         *     {@link pl.edu.agh.xsd.Settype }
         *     
         */
        public void setSet(Settype value) {
            this.set = value;
        }

        /**
         * Gets the value of the setexpr property.
         * 
         * @return
         *     possible object is
         *     {@link Setexprtype }
         *     
         */
        public Setexprtype getSetexpr() {
            return setexpr;
        }

        /**
         * Sets the value of the setexpr property.
         * 
         * @param value
         *     allowed object is
         *     {@link Setexprtype }
         *     
         */
        public void setSetexpr(Setexprtype value) {
            this.setexpr = value;
        }

        /**
         * Gets the value of the tuple property.
         * 
         * @return
         *     possible object is
         *     {@link pl.edu.agh.xsd.Tupletype }
         *     
         */
        public Tupletype getTuple() {
            return tuple;
        }

        /**
         * Sets the value of the tuple property.
         * 
         * @param value
         *     allowed object is
         *     {@link pl.edu.agh.xsd.Tupletype }
         *     
         */
        public void setTuple(Tupletype value) {
            this.tuple = value;
        }

    }

}
