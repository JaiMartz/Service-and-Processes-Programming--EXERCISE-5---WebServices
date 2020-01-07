
package servidorwebservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPaisesZona", namespace = "http://servidorwebservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPaisesZona", namespace = "http://servidorwebservices/")
public class GetPaisesZona {

    @XmlElement(name = "arg0", namespace = "")
    private long arg0;

    /**
     * 
     * @return
     *     returns long
     */
    public long getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(long arg0) {
        this.arg0 = arg0;
    }

}
