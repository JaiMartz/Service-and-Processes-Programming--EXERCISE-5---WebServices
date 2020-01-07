
package servidorwebservices.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMonedasResponse", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMonedasResponse", namespace = "http://servidorwebservices/")
public class GetMonedasResponse {

    @XmlElement(name = "return", namespace = "")
    private List<modelos.Moneda> _return;

    /**
     * 
     * @return
     *     returns List<Moneda>
     */
    public List<modelos.Moneda> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<modelos.Moneda> _return) {
        this._return = _return;
    }

}
