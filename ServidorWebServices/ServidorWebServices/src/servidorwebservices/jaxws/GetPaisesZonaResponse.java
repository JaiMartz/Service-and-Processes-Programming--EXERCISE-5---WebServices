
package servidorwebservices.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPaisesZonaResponse", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPaisesZonaResponse", namespace = "http://servidorwebservices/")
public class GetPaisesZonaResponse {

    @XmlElement(name = "return", namespace = "")
    private List<modelos.Pais> _return;

    /**
     * 
     * @return
     *     returns List<Pais>
     */
    public List<modelos.Pais> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<modelos.Pais> _return) {
        this._return = _return;
    }

}
