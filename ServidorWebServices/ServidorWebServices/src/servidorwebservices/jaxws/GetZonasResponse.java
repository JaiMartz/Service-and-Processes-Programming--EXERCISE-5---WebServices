
package servidorwebservices.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getZonasResponse", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getZonasResponse", namespace = "http://servidorwebservices/")
public class GetZonasResponse {

    @XmlElement(name = "return", namespace = "")
    private List<modelos.Zona> _return;

    /**
     * 
     * @return
     *     returns List<Zona>
     */
    public List<modelos.Zona> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<modelos.Zona> _return) {
        this._return = _return;
    }

}
