
package servidorwebservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMonedaByCodigoResponse", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMonedaByCodigoResponse", namespace = "http://servidorwebservices/")
public class GetMonedaByCodigoResponse {

    @XmlElement(name = "return", namespace = "")
    private modelos.Moneda _return;

    /**
     * 
     * @return
     *     returns Moneda
     */
    public modelos.Moneda getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(modelos.Moneda _return) {
        this._return = _return;
    }

}
