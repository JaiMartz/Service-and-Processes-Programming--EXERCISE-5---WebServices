
package servidorwebservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getZonaByIdResponse", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getZonaByIdResponse", namespace = "http://servidorwebservices/")
public class GetZonaByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private modelos.Zona _return;

    /**
     * 
     * @return
     *     returns Zona
     */
    public modelos.Zona getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(modelos.Zona _return) {
        this._return = _return;
    }

}
