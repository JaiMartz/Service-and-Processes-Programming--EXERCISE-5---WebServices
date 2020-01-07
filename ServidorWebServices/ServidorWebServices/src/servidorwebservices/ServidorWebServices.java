/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorwebservices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.ws.Endpoint;
import modelos.Moneda;
import modelos.Pais;
import modelos.Zona;

/**
 *
 * @author alconesp
 */
public class ServidorWebServices {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorWebServices programa = new ServidorWebServices();
        programa.iniciar();
        
        Endpoint.publish("http://localhost:8080/paisesWebService", new PaisesWebService());
    }
    
    public void iniciar() {
        //Create a connectionto the database "paises.odb"
        //In case that the file doesn't exist , it'll be created.
        
        // Creamos una conexión a "base de datos"
        // En caso de no existir el fichero, se creara
        entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        entityManager = entityManagerFactory.createEntityManager();
        
        if (!chequearDatos()) {
            System.out.println("Insertando valores en la base de datos.");
            insertarDatos();
        }
        
        entityManager.close();
        entityManagerFactory.close();
    }
    
    /**
     * Method that check data information by SQL.
     * @return 
     */
    public boolean chequearDatos() {
        try {
            Query q1 = entityManager.createQuery(
                "SELECT COUNT(pais) FROM Pais pais"
            );
            return (long) q1.getSingleResult() > 0;
        } catch (Exception e) {
            // La base de datos no contiene valores
            return false;
        }
    }
    
    /**
     * Method that insert all data and begin and commit the transaction.
     */
    public void insertarDatos() {
        entityManager.getTransaction().begin();
        insertarMonedas();
        insertarZonas();
        insertarPaises();
        entityManager.getTransaction().commit();
    }
    
    /**
     * Method that insert all the Moneda objects into the database.
     */
    private void insertarMonedas() {
        // Inserción de monedas
        entityManager.persist(new Moneda("AED", "Dirham"));
        entityManager.persist(new Moneda("AFN", "Afgani Afgano"));
        entityManager.persist(new Moneda("ALL", "Lek Albanés"));
        entityManager.persist(new Moneda("AMD", "Dram Armenio"));
        entityManager.persist(new Moneda("ANG", "Florín Antillano Neerlandés"));
        entityManager.persist(new Moneda("AOA", "Kwanza Angoleño"));
        entityManager.persist(new Moneda("ARS", "Peso Argentino"));
        entityManager.persist(new Moneda("AUD", "Dólar Australiano"));
        entityManager.persist(new Moneda("AWG", "Florín Arubeño"));
        entityManager.persist(new Moneda("AZN", "Manat Azerbaiyano"));
        entityManager.persist(new Moneda("BAM", "Marco Convertible"));
        entityManager.persist(new Moneda("BBD", "Dólar"));
        entityManager.persist(new Moneda("BDT", "Taka"));
        entityManager.persist(new Moneda("BGN", "Lev Búlgaro"));
        entityManager.persist(new Moneda("BHD", "Dinar Bahreini"));
        entityManager.persist(new Moneda("BIF", "Franco Burundés"));
        entityManager.persist(new Moneda("BMD", "Dólar"));
        entityManager.persist(new Moneda("BND", "Dólar"));
        entityManager.persist(new Moneda("BOB", "Boliviano"));
        entityManager.persist(new Moneda("BRL", "Real Brasileño"));
        entityManager.persist(new Moneda("BSD", "Dólar Bahameño"));
        entityManager.persist(new Moneda("BTN", "Ngultrum"));
        entityManager.persist(new Moneda("BWP", "Pula"));
        entityManager.persist(new Moneda("BYN", "Rublo Bielorruso"));
        entityManager.persist(new Moneda("BZD", "Dólar"));
        entityManager.persist(new Moneda("CAD", "Dólar Canadiense"));
        entityManager.persist(new Moneda("CDF", "Franco Congoleño"));
        entityManager.persist(new Moneda("CHF", "Franco Suizo"));
        entityManager.persist(new Moneda("CLP", "Peso Chileno"));
        entityManager.persist(new Moneda("CNY", "Rmb Yuan Renminbi Chino"));
        entityManager.persist(new Moneda("COP", "Peso Colombiano"));
        entityManager.persist(new Moneda("CRC", "Colón Costarricense"));
        entityManager.persist(new Moneda("CUC", "Peso Cubano Convertible"));
        entityManager.persist(new Moneda("CVE", "Escudo Caboverdiano"));
        entityManager.persist(new Moneda("CZK", "Koruna Checa"));
        entityManager.persist(new Moneda("DJF", "Franco Yibutiano"));
        entityManager.persist(new Moneda("DKK", "Corona Danesa"));
        entityManager.persist(new Moneda("DOP", "Peso Dominicano"));
        entityManager.persist(new Moneda("DZD", "Dinar Algerino"));
        entityManager.persist(new Moneda("EGP", "Libra Egipcia"));
        entityManager.persist(new Moneda("ERN", "Nafka Eritreo"));
        entityManager.persist(new Moneda("ETB", "Birr Etiope"));
        entityManager.persist(new Moneda("EUR", "Euro"));
        entityManager.persist(new Moneda("FJD", "Dólar Fijiano"));
        entityManager.persist(new Moneda("GBP", "Libra Esterlina"));
        entityManager.persist(new Moneda("GEL", "Lari Georgiano"));
        entityManager.persist(new Moneda("GGP", "Libra"));
        entityManager.persist(new Moneda("GHS", "Cedi Ghanés"));
        entityManager.persist(new Moneda("GIP", "Libra"));
        entityManager.persist(new Moneda("GMD", "Dalasi Gambiano"));
        entityManager.persist(new Moneda("GNF", "Franco Guineano"));
        entityManager.persist(new Moneda("GTQ", "Quetzal Guatemalteco"));
        entityManager.persist(new Moneda("GYD", "Dólar Guyanés"));
        entityManager.persist(new Moneda("HKD", "Dólar"));
        entityManager.persist(new Moneda("HNL", "Lempira Hondureño"));
        entityManager.persist(new Moneda("HRK", "Kuna Croata"));
        entityManager.persist(new Moneda("HTG", "Gourde Haitiano"));
        entityManager.persist(new Moneda("HUF", "Forint Húngaro"));
        entityManager.persist(new Moneda("IDR", "Rupiah Indonesia"));
        entityManager.persist(new Moneda("ILS", "Nuevo Shékel Israeli"));
        entityManager.persist(new Moneda("IMP", "Libra"));
        entityManager.persist(new Moneda("INR", "Rupia India"));
        entityManager.persist(new Moneda("IQD", "Dinar Iraquí"));
        entityManager.persist(new Moneda("IRR", "Rial Iraní"));
        entityManager.persist(new Moneda("ISK", "Króna Islandesa"));
        entityManager.persist(new Moneda("JEP", "Libra"));
        entityManager.persist(new Moneda("JMD", "Dólar Jamaicano"));
        entityManager.persist(new Moneda("JOD", "Dinar Jordano"));
        entityManager.persist(new Moneda("JPY", "Yen Japonés"));
        entityManager.persist(new Moneda("KES", "Chelín Keniata"));
        entityManager.persist(new Moneda("KGS", "Som Kirguís"));
        entityManager.persist(new Moneda("KHR", "Riel Camboyano"));
        entityManager.persist(new Moneda("KID", "Dólar De Kiribati"));
        entityManager.persist(new Moneda("KMF", "Franco Comoriano"));
        entityManager.persist(new Moneda("KPW", "Won Norcoreano"));
        entityManager.persist(new Moneda("KRW", "Won Surcoreano"));
        entityManager.persist(new Moneda("KWD", "Dinar Kuwaití"));
        entityManager.persist(new Moneda("KYD", "Dólar Caimano"));
        entityManager.persist(new Moneda("KZT", "Tenge Kazajo"));
        entityManager.persist(new Moneda("LAK", "Kip Lao"));
        entityManager.persist(new Moneda("LBP", "Libra Libanesa"));
        entityManager.persist(new Moneda("LKR", "Rupia"));
        entityManager.persist(new Moneda("LRD", "Dólar Liberiano"));
        entityManager.persist(new Moneda("LSL", "Loti Lesotense"));
        entityManager.persist(new Moneda("LTL", "Litas Lituano"));
        entityManager.persist(new Moneda("LYD", "Dinar Libio"));
        entityManager.persist(new Moneda("MAD", "Dirham Marroquí"));
        entityManager.persist(new Moneda("MDL", "Leu Moldavo"));
        entityManager.persist(new Moneda("MGA", "Ariary Malgache"));
        entityManager.persist(new Moneda("MKD", "Denar Macedonio"));
        entityManager.persist(new Moneda("MMK", "Kyat Birmano"));
        entityManager.persist(new Moneda("MNT", "Tughrik Mongol"));
        entityManager.persist(new Moneda("MOP", "Pataca"));
        entityManager.persist(new Moneda("MRU", "Ouguiya Mauritana"));
        entityManager.persist(new Moneda("MUR", "Rupia Mauricia"));
        entityManager.persist(new Moneda("MVR", "Rufiyaa Maldiva"));
        entityManager.persist(new Moneda("MWK", "Kwacha Malauí"));
        entityManager.persist(new Moneda("MXN", "Peso Mexicano"));
        entityManager.persist(new Moneda("MYR", "Ringgit Malayo"));
        entityManager.persist(new Moneda("MZN", "Metical Mozambiqueño"));
        entityManager.persist(new Moneda("NAD", "Dólar Namibio"));
        entityManager.persist(new Moneda("NGN", "Naira Nigeriana"));
        entityManager.persist(new Moneda("NIO", "Córdoba Nicaragüense"));
        entityManager.persist(new Moneda("NOK", "Corona Noruega"));
        entityManager.persist(new Moneda("NPR", "Rupia Nepalesa"));
        entityManager.persist(new Moneda("NZD", "Dólar Neozelandés"));
        entityManager.persist(new Moneda("OMR", "Rial Omaní"));
        entityManager.persist(new Moneda("PAB", "Balboa Panameña"));
        entityManager.persist(new Moneda("PEN", "Nuevo Sol Peruano"));
        entityManager.persist(new Moneda("PGK", "Kina"));
        entityManager.persist(new Moneda("PHP", "Peso Filipino"));
        entityManager.persist(new Moneda("PKR", "Rupia Pakistaní"));
        entityManager.persist(new Moneda("PLN", "Złoty Polaco"));
        entityManager.persist(new Moneda("PYG", "Guaraní"));
        entityManager.persist(new Moneda("QAR", "Rial Qatarí"));
        entityManager.persist(new Moneda("RON", "Leu Rumano"));
        entityManager.persist(new Moneda("RSD", "Dinar"));
        entityManager.persist(new Moneda("RUB", "Rublo Ruso"));
        entityManager.persist(new Moneda("RWF", "Franco Ruandés"));
        entityManager.persist(new Moneda("SAR", "Riyal Saudí"));
        entityManager.persist(new Moneda("SBD", "Dólar"));
        entityManager.persist(new Moneda("SCR", "Rupia"));
        entityManager.persist(new Moneda("SDG", "Dinar Sudanés"));
        entityManager.persist(new Moneda("SEK", "Corona Sueca"));
        entityManager.persist(new Moneda("SGD", "Dólar"));
        entityManager.persist(new Moneda("SHP", "Libra"));
        entityManager.persist(new Moneda("SLL", "Leone"));
        entityManager.persist(new Moneda("SOS", "Chelín Somalí"));
        entityManager.persist(new Moneda("SRD", "Dólar Surinamés"));
        entityManager.persist(new Moneda("SSP", "South Sudanese Pound"));
        entityManager.persist(new Moneda("STN", "Dobra"));
        entityManager.persist(new Moneda("SVC", "Colón"));
        entityManager.persist(new Moneda("SYP", "Libra Siria"));
        entityManager.persist(new Moneda("SZL", "Lilangeni Suazi"));
        entityManager.persist(new Moneda("THB", "Baht Tailandés"));
        entityManager.persist(new Moneda("TJS", "Somoni Tayik"));
        entityManager.persist(new Moneda("TMT", "Manat Turcomano"));
        entityManager.persist(new Moneda("TND", "Dinar Tunecino"));
        entityManager.persist(new Moneda("TOP", "Pa'Anga Tongano"));
        entityManager.persist(new Moneda("TRY", "Nueva Lira"));
        entityManager.persist(new Moneda("TTD", "Dólar"));
        entityManager.persist(new Moneda("TWD", "Nuevo Dólar Taiwanés"));
        entityManager.persist(new Moneda("TZS", "Chelín Tanzano"));
        entityManager.persist(new Moneda("UAH", "Grivna Ucrainiana"));
        entityManager.persist(new Moneda("UGX", "Chelín Ugandés"));
        entityManager.persist(new Moneda("USD", "Dólar Estadounidense"));
        entityManager.persist(new Moneda("UYU", "Peso Uruguayo"));
        entityManager.persist(new Moneda("UZS", "Som Uzbeko"));
        entityManager.persist(new Moneda("VES", "Bolívar Soberano"));
        entityManager.persist(new Moneda("VND", "Dong Vietnamito"));
        entityManager.persist(new Moneda("VUV", "Vatu Vanuatense"));
        entityManager.persist(new Moneda("WST", "Tala Samoana"));
        entityManager.persist(new Moneda("XAF", "Franco Cfa"));
        entityManager.persist(new Moneda("XCD", "Dólar"));
        entityManager.persist(new Moneda("XOF", "Franco Cfa"));
        entityManager.persist(new Moneda("XPF", "Franco Cfp"));
        entityManager.persist(new Moneda("YER", "Rial Yemeni"));
        entityManager.persist(new Moneda("YUN", "Dinar Yugoslavo"));
        entityManager.persist(new Moneda("ZAR", "Rand Sudafricano"));
        entityManager.persist(new Moneda("ZMW", "Kwacha Zambiano"));
        entityManager.persist(new Moneda("ZWL", "Dólar Zimbabuense"));
    }
    
    /**
     * Method that insert all the Zona objects into the database.
     */
    private void insertarZonas() {
        // Inserción de zonas
        entityManager.persist(new Zona(1, "Africa"));
        entityManager.persist(new Zona(2, "América del Norte"));
        entityManager.persist(new Zona(3, "América del Sur"));
        entityManager.persist(new Zona(4, "Antillas/Caribe"));
        entityManager.persist(new Zona(5, "Asia"));
        entityManager.persist(new Zona(6, "Europa"));
        entityManager.persist(new Zona(7, "Europa del Este"));
        entityManager.persist(new Zona(8, "Medio Oriente"));
        entityManager.persist(new Zona(9, "Pacífico"));
    }
    
    /**
     * Method that insert all the Pais objects into the database.
     */
    private void insertarPaises() {
        // Inserción de países
        entityManager.persist(new Pais(1, "Martinica", 4, "EUR", "MTQ", "MQ"));
        entityManager.persist(new Pais(2, "Afganistán", 5, "AFN", "AFG", "AF"));
        entityManager.persist(new Pais(3, "África del Sur", 1, "ZAR", "ZAF", "ZA"));
        entityManager.persist(new Pais(4, "Albania", 7, "ALL", "ALB", "AL"));
        entityManager.persist(new Pais(5, "Alemania", 6, "EUR", "DEU", "DE"));
        entityManager.persist(new Pais(6, "Andorra", 6, "EUR", "AND", "AD"));
        entityManager.persist(new Pais(7, "Angola", 1, "AOA", "AGO", "AO"));
        entityManager.persist(new Pais(8, "Anguila", 4, "XCD", "AIA", "AI"));
        entityManager.persist(new Pais(9, "Antigua y Barbuda", 4, "XCD", "ATG", "AG"));
        entityManager.persist(new Pais(10, "Antillas Neerlandesas", 4, "ANG", "ANT", "AN"));
        entityManager.persist(new Pais(11, "Arabia Saudí", 8, "SAR", "SAU", "SA"));
        entityManager.persist(new Pais(12, "Argelia", 1, "DZD", "DZA", "DZ"));
        entityManager.persist(new Pais(13, "Argentina", 3, "ARS", "ARG", "AR"));
        entityManager.persist(new Pais(14, "Armenia", 7, "AMD", "ARM", "AM"));
        entityManager.persist(new Pais(15, "Aruba", 4, "AWG", "ABW", "AW"));
        entityManager.persist(new Pais(16, "Australia", 9, "AUD", "AUS", "AU"));
        entityManager.persist(new Pais(17, "Austria", 6, "EUR", "AUT", "AT"));
        entityManager.persist(new Pais(18, "Azerbaiyán", 7, "AZN", "AZE", "AZ"));
        entityManager.persist(new Pais(19, "Bahamas", 4, "BSD", "BHS", "BS"));
        entityManager.persist(new Pais(20, "Bahrein", 8, "BHD", "BHR", "BH"));
        entityManager.persist(new Pais(21, "Bangladesh", 5, "BDT", "BGD", "BD"));
        entityManager.persist(new Pais(22, "Barbados", 4, "BBD", "BRB", "BB"));
        entityManager.persist(new Pais(23, "Bélgica", 6, "EUR", "BEL", "BE"));
        entityManager.persist(new Pais(24, "Belice", 4, "BZD", "BLZ", "BZ"));
        entityManager.persist(new Pais(25, "Benin", 1, "XOF", "BEN", "BJ"));
        entityManager.persist(new Pais(26, "Bermuda", 4, "BMD", "BMU", "BM"));
        entityManager.persist(new Pais(27, "Bhoutan", 5, "BTN", "BTN", "BT"));
        entityManager.persist(new Pais(28, "Bielorrusia", 7, "BYN", "BLR", "BY"));
        entityManager.persist(new Pais(29, "Birmania (Myanmar)", 5, "MMK", "MMR", "MM"));
        entityManager.persist(new Pais(30, "Bolivia", 3, "BOB", "BOL", "BO"));
        entityManager.persist(new Pais(31, "Bosnia y Herzegovina", 7, "BAM", "BIH", "BA"));
        entityManager.persist(new Pais(32, "Botsuana", 1, "BWP", "BWA", "BW"));
        entityManager.persist(new Pais(33, "Brasil", 3, "BRL", "BRA", "BR"));
        entityManager.persist(new Pais(34, "Brunéi", 8, "BND", "BRN", "BN"));
        entityManager.persist(new Pais(35, "Bulgaria", 7, "BGN", "BGR", "BG"));
        entityManager.persist(new Pais(36, "Burkina Faso", 1, "XOF", "BFA", "BF"));
        entityManager.persist(new Pais(37, "Burundi", 1, "BIF", "BDI", "BI"));
        entityManager.persist(new Pais(38, "Cabo Verde", 1, "CVE", "CPV", "CV"));
        entityManager.persist(new Pais(39, "Camboya", 5, "KHR", "KHM", "KH"));
        entityManager.persist(new Pais(40, "Camerún", 1, "XAF", "CMR", "CM"));
        entityManager.persist(new Pais(41, "Canadá", 2, "CAD", "CAN", "CA"));
        entityManager.persist(new Pais(42, "Chad", 1, "XAF", "TCD", "TD"));
        entityManager.persist(new Pais(43, "Chile", 3, "CLP", "CHL", "CL"));
        entityManager.persist(new Pais(44, "China", 5, "CNY", "CHN", "CN"));
        entityManager.persist(new Pais(45, "Chipre", 6, "EUR", "CYP", "CY"));
        entityManager.persist(new Pais(46, "Ciudad del Vaticano", 6, "EUR", "VAT", "VA"));
        entityManager.persist(new Pais(47, "Colombia", 3, "COP", "COL", "CO"));
        entityManager.persist(new Pais(48, "Comoras", 1, "KMF", "COM", "KM"));
        entityManager.persist(new Pais(49, "Congo (Brazzaville)", 1, "XAF", "COG", "CG"));
        entityManager.persist(new Pais(50, "Congo/Kinshasa (RDC)", 1, "CDF", "COD", "CD"));
        entityManager.persist(new Pais(51, "Corea del Norte", 5, "KPW", "PRK", "KP"));
        entityManager.persist(new Pais(52, "Corea del Sur", 5, "KRW", "KOR", "KR"));
        entityManager.persist(new Pais(53, "Costa de Marfil", 1, "XOF", "CIV", "CI"));
        entityManager.persist(new Pais(54, "Costa Rica", 3, "CRC", "CRI", "CR"));
        entityManager.persist(new Pais(55, "Croacia", 7, "HRK", "HRV", "HR"));
        entityManager.persist(new Pais(56, "Cuba", 4, "CUC", "CUB", "CU"));
        entityManager.persist(new Pais(57, "Dinamarca", 6, "DKK", "DNK", "DK"));
        entityManager.persist(new Pais(58, "Dominique", 4, "XCD", "DMA", "DM"));
        entityManager.persist(new Pais(59, "Ecuador", 3, "USD", "ECU", "EC"));
        entityManager.persist(new Pais(60, "Egipto", 8, "EGP", "EGY", "EG"));
        entityManager.persist(new Pais(61, "Emiratos Arabes Unidos", 8, "AED", "ARE", "AE"));
        entityManager.persist(new Pais(62, "Eritrea", 8, "ERN", "ERI", "ER"));
        entityManager.persist(new Pais(63, "Eslovaquia", 7, "EUR", "SVK", "SK"));
        entityManager.persist(new Pais(64, "Eslovenia", 7, "EUR", "SVN", "SI"));
        entityManager.persist(new Pais(65, "España", 6, "EUR", "ESP", "ES"));
        entityManager.persist(new Pais(66, "Estados Unidos", 2, "USD", "USA", "US"));
        entityManager.persist(new Pais(67, "Estonia", 7, "EUR", "EST", "EE"));
        entityManager.persist(new Pais(68, "Etiopía", 1, "ETB", "ETH", "ET"));
        entityManager.persist(new Pais(69, "Fiji", 9, "FJD", "FJI", "FJ"));
        entityManager.persist(new Pais(70, "Filipinas", 5, "PHP", "PHL", "PH"));
        entityManager.persist(new Pais(71, "Finlandia", 6, "EUR", "FIN", "FI"));
        entityManager.persist(new Pais(72, "Francia", 6, "EUR", "FRA", "FR"));
        entityManager.persist(new Pais(73, "Francia metropolitana", 6, "EUR", "FXX", "FR"));
        entityManager.persist(new Pais(74, "FSU", 7, "RUB", "SUN", "RU"));
        entityManager.persist(new Pais(75, "Gabón", 1, "XAF", "GAB", "GA"));
        entityManager.persist(new Pais(76, "Gambia", 1, "GMD", "GMB", "GM"));
        entityManager.persist(new Pais(77, "Georgia", 7, "GEL", "GEO", "GE"));
        entityManager.persist(new Pais(78, "Ghana", 1, "GHS", "GHA", "GH"));
        entityManager.persist(new Pais(79, "Gibraltar", 6, "GIP", "GIB", "GI"));
        entityManager.persist(new Pais(80, "Gran Bretaña", 6, "GBP", "GBR", "UK"));
        entityManager.persist(new Pais(81, "Grecia", 6, "EUR", "GRC", "GR"));
        entityManager.persist(new Pais(82, "Grenade", 4, "XCD", "GRD", "GD"));
        entityManager.persist(new Pais(83, "Groenlandia (Dinamarca)", 2, "DKK", "GRL", "GL"));
        entityManager.persist(new Pais(84, "Guadalupe", 4, "EUR", "GLP", "GP"));
        entityManager.persist(new Pais(85, "Guam (EE.UU.)", 5, "USD", "GUM", "GU"));
        entityManager.persist(new Pais(86, "Guatemala", 3, "GTQ", "GTM", "GT"));
        entityManager.persist(new Pais(87, "Guayana", 3, "GYD", "GUY", "GY"));
        entityManager.persist(new Pais(88, "Guernesey", 6, "GGP", "", "GG"));
        entityManager.persist(new Pais(89, "Guiana francés", 3, "EUR", "GUF", "GF"));
        entityManager.persist(new Pais(90, "Guinea", 1, "GNF", "GIN", "GN"));
        entityManager.persist(new Pais(91, "Guinea Bissau", 1, "XAF", "GNB", "GW"));
        entityManager.persist(new Pais(92, "Haití", 4, "HTG", "HTI", "HT"));
        entityManager.persist(new Pais(93, "Holanda", 6, "EUR", "NLD", "NL"));
        entityManager.persist(new Pais(94, "Honduras", 3, "HNL", "HND", "HN"));
        entityManager.persist(new Pais(95, "Hong-Kong", 5, "HKD", "HKG", "HK"));
        entityManager.persist(new Pais(96, "Hungría", 7, "HUF", "HUN", "HU"));
        entityManager.persist(new Pais(97, "India", 5, "INR", "IND", "IN"));
        entityManager.persist(new Pais(98, "Indonesia", 5, "IDR", "IDN", "ID"));
        entityManager.persist(new Pais(99, "Irak", 8, "IQD", "IRQ", "IQ"));
        entityManager.persist(new Pais(100, "Irán", 8, "IRR", "IRN", "IR"));
        entityManager.persist(new Pais(101, "Irlanda", 6, "EUR", "IRL", "IE"));
        entityManager.persist(new Pais(102, "Isla de Man", 6, "IMP", "", "IM"));
        entityManager.persist(new Pais(103, "Isla de Navidad", 9, "AUD", "CXR", "CX"));
        entityManager.persist(new Pais(104, "Isla Mauricio", 1, "MUR", "MUS", "MU"));
        entityManager.persist(new Pais(105, "Islandia", 6, "ISK", "ISL", "IS"));
        entityManager.persist(new Pais(106, "Islas Caimán", 4, "KYD", "CYM", "KY"));
        entityManager.persist(new Pais(107, "Islas Cocos", 9, "AUD", "CCK", "CC"));
        entityManager.persist(new Pais(108, "Islas Cook", 9, "NZD", "COK", "CK"));
        entityManager.persist(new Pais(109, "Islas del Norte Marianne", 5, "USD", "MNP", "MP"));
        entityManager.persist(new Pais(110, "Islas Feroe", 6, "DKK", "FRO", "FO"));
        entityManager.persist(new Pais(111, "Islas Heard y Macdonald", 9, "AUD", "HMD", "HM"));
        entityManager.persist(new Pais(112, "Islas Marshall", 5, "USD", "MHL", "MH"));
        entityManager.persist(new Pais(113, "Islas Salomón", 9, "SBD", "SLB", "SB"));
        entityManager.persist(new Pais(114, "Islas Vírgenes Británicas", 4, "USD", "VGB", "VG"));
        entityManager.persist(new Pais(115, "Islas Vírgenes de los Estados Unidos", 4, "USD", "VIR", "VI"));
        entityManager.persist(new Pais(116, "Israel", 8, "ILS", "ISR", "IL"));
        entityManager.persist(new Pais(117, "Italia", 6, "EUR", "ITA", "IT"));
        entityManager.persist(new Pais(118, "Jamaica", 4, "JMD", "JAM", "JM"));
        entityManager.persist(new Pais(119, "Japón", 5, "JPY", "JPN", "JP"));
        entityManager.persist(new Pais(120, "Jersey", 6, "JEP", "", "JE"));
        entityManager.persist(new Pais(121, "Jordania", 8, "JOD", "JOR", "JO"));
        entityManager.persist(new Pais(122, "Kazajstán", 5, "KZT", "KAZ", "KZ"));
        entityManager.persist(new Pais(123, "Kenia", 1, "KES", "KEN", "KE"));
        entityManager.persist(new Pais(124, "Kirguistán", 5, "KGS", "KGZ", "KG"));
        entityManager.persist(new Pais(125, "Kiribati", 5, "KID", "KIR", "KI"));
        entityManager.persist(new Pais(126, "Kuwait", 8, "KWD", "KWT", "KW"));
        entityManager.persist(new Pais(127, "La Reunión", 1, "EUR", "REU", "RE"));
        entityManager.persist(new Pais(128, "Laos", 5, "LAK", "LAO", "LA"));
        entityManager.persist(new Pais(129, "Lesotho", 1, "LSL", "LSO", "LS"));
        entityManager.persist(new Pais(130, "Letonia", 7, "EUR", "LVA", "LV"));
        entityManager.persist(new Pais(131, "Líbano", 8, "LBP", "LBN", "LB"));
        entityManager.persist(new Pais(132, "Liberia", 1, "LRD", "LBR", "LR"));
        entityManager.persist(new Pais(133, "Libia", 1, "LYD", "LBY", "LY"));
        entityManager.persist(new Pais(134, "Liechtenstein", 6, "CHF", "LIE", "LI"));
        entityManager.persist(new Pais(135, "Lituania", 7, "LTL", "LTU", "LT"));
        entityManager.persist(new Pais(136, "Luxemburgo", 6, "EUR", "LUX", "LU"));
        entityManager.persist(new Pais(137, "Macao", 5, "MOP", "MAC", "MO"));
        entityManager.persist(new Pais(138, "Macedonia", 7, "MKD", "MKD", "MK"));
        entityManager.persist(new Pais(139, "Madagascar", 1, "MGA", "MDG", "MG"));
        entityManager.persist(new Pais(140, "Malasia", 5, "MYR", "MYS", "MY"));
        entityManager.persist(new Pais(141, "Malawi", 1, "MWK", "MWI", "MW"));
        entityManager.persist(new Pais(142, "Maldivas", 5, "MVR", "MDV", "MV"));
        entityManager.persist(new Pais(143, "Malí", 1, "XOF", "MLI", "ML"));
        entityManager.persist(new Pais(144, "Malta", 6, "EUR", "MLT", "MT"));
        entityManager.persist(new Pais(145, "Marruecos", 1, "MAD", "MAR", "MA"));
        entityManager.persist(new Pais(146, "Mauritania", 1, "MRU", "MRT", "MR"));
        entityManager.persist(new Pais(147, "Mayotte", 1, "EUR", "MYT", "YT"));
        entityManager.persist(new Pais(148, "México", 3, "MXN", "MEX", "MX"));
        entityManager.persist(new Pais(149, "Micronesia", 9, "USD", "FSM", "FM"));
        entityManager.persist(new Pais(150, "Moldavia", 6, "MDL", "MDA", "MD"));
        entityManager.persist(new Pais(151, "Mónaco", 6, "EUR", "MCO", "MC"));
        entityManager.persist(new Pais(152, "Mongolia", 5, "MNT", "MNG", "MN"));
        entityManager.persist(new Pais(153, "Montenegro", 7, "EUR", "MNE", "ME"));
        entityManager.persist(new Pais(154, "Montserrat", 4, "XCD", "MSR", "MS"));
        entityManager.persist(new Pais(155, "Mozambique", 1, "MZN", "MOZ", "MZ"));
        entityManager.persist(new Pais(156, "Namibia", 1, "NAD", "NAM", "NA"));
        entityManager.persist(new Pais(157, "Nauru", 9, "AUD", "NRU", "NR"));
        entityManager.persist(new Pais(158, "Nepal", 5, "NPR", "NPL", "NP"));
        entityManager.persist(new Pais(159, "Nicaragua", 3, "NIO", "NIC", "NI"));
        entityManager.persist(new Pais(160, "Níger", 1, "XOF", "NER", "NE"));
        entityManager.persist(new Pais(161, "Nigeria", 1, "NGN", "NGA", "NG"));
        entityManager.persist(new Pais(162, "Niue", 9, "NZD", "NIU", "NU"));
        entityManager.persist(new Pais(163, "Norfolk", 9, "AUD", "NFK", "NF"));
        entityManager.persist(new Pais(164, "Noruega", 6, "NOK", "NOR", "NO"));
        entityManager.persist(new Pais(165, "Nueva Caledonia", 9, "XPF", "NCL", "NC"));
        entityManager.persist(new Pais(166, "Nueva Zelanda", 9, "NZD", "NZL", "NZ"));
        entityManager.persist(new Pais(167, "Omán", 8, "OMR", "OMN", "OM"));
        entityManager.persist(new Pais(168, "Pakistán", 5, "PKR", "PAK", "PK"));
        entityManager.persist(new Pais(169, "Palau", 9, "USD", "PLW", "PW"));
        entityManager.persist(new Pais(170, "Palestina", 8, "ILS", "", "PS"));
        entityManager.persist(new Pais(171, "Panamá", 9, "PAB", "PAN", "PA"));
        entityManager.persist(new Pais(172, "Papuasia-Nueva-Guinea", 5, "PGK", "PNG", "PG"));
        entityManager.persist(new Pais(173, "Paraguay", 3, "PYG", "PRY", "PY"));
        entityManager.persist(new Pais(174, "Perú", 3, "PEN", "PER", "PE"));
        entityManager.persist(new Pais(175, "Pitcairn", 9, "NZD", "PCN", "PN"));
        entityManager.persist(new Pais(176, "Polinesia francese", 9, "XPF", "PYF", "PF"));
        entityManager.persist(new Pais(177, "Polonia", 7, "PLN", "POL", "PL"));
        entityManager.persist(new Pais(178, "Portugal", 6, "EUR", "PRT", "PT"));
        entityManager.persist(new Pais(179, "Puerto Rico", 4, "USD", "PRI", "PR"));
        entityManager.persist(new Pais(180, "Qatar", 8, "QAR", "QAT", "QA"));
        entityManager.persist(new Pais(181, "República Centroafricana", 1, "XAF", "CAF", "CF"));
        entityManager.persist(new Pais(182, "República Checa", 7, "CZK", "CZE", "CS"));
        entityManager.persist(new Pais(183, "República Dominicana", 4, "DOP", "DOM", "DO"));
        entityManager.persist(new Pais(184, "Ruanda", 1, "RWF", "RWA", "RW"));
        entityManager.persist(new Pais(185, "Rumania", 7, "RON", "ROM", "RO"));
        entityManager.persist(new Pais(186, "Rusia", 7, "RUB", "RUS", "RU"));
        entityManager.persist(new Pais(187, "Sáhara Occidental", 1, "MAD", "ESH", "EH"));
        entityManager.persist(new Pais(188, "Salvador", 3, "SVC", "SLV", "SV"));
        entityManager.persist(new Pais(189, "Samoa Americana", 9, "USD", "ASM", "AS"));
        entityManager.persist(new Pais(190, "Samoa Occidentales", 9, "WST", "WSM", "WS"));
        entityManager.persist(new Pais(191, "San Cristóbal y Nieves", 4, "XCD", "KNA", "KN"));
        entityManager.persist(new Pais(192, "San Marino", 6, "EUR", "SMR", "SM"));
        entityManager.persist(new Pais(193, "San Pedro y Miquelón", 2, "EUR", "SPM", "PM"));
        entityManager.persist(new Pais(194, "San Vicente y las Granadinas", 4, "XCD", "VCT", "VC"));
        entityManager.persist(new Pais(195, "Santa Elena", 1, "SHP", "SHN", "SH"));
        entityManager.persist(new Pais(196, "Santa Lucía", 4, "XCD", "LCA", "LC"));
        entityManager.persist(new Pais(197, "Santo Tomé y Príncipe", 1, "STN", "STP", "ST"));
        entityManager.persist(new Pais(198, "Senegal", 1, "XOF", "SEN", "SN"));
        entityManager.persist(new Pais(199, "Serbia", 7, "RSD", "SRB", "RS"));
        entityManager.persist(new Pais(200, "Seychelles", 1, "SCR", "SYC", "SC"));
        entityManager.persist(new Pais(201, "Sierra Leona", 1, "SLL", "SLE", "SL"));
        entityManager.persist(new Pais(202, "Singapur", 5, "SGD", "SGP", "SG"));
        entityManager.persist(new Pais(203, "Sint Maarten", 4, "ANG", "", "SX"));
        entityManager.persist(new Pais(204, "Siria", 8, "SYP", "SYR", "SY"));
        entityManager.persist(new Pais(205, "Somalia", 1, "SOS", "SOM", "SO"));
        entityManager.persist(new Pais(206, "Sri Lanka", 5, "LKR", "LKA", "LK"));
        entityManager.persist(new Pais(207, "Sudán", 1, "SDG", "SDN", "SD"));
        entityManager.persist(new Pais(208, "Sudán del Sur", 1, "SSP", "SSD", "SS"));
        entityManager.persist(new Pais(209, "Suecia", 6, "SEK", "SWE", "SE"));
        entityManager.persist(new Pais(210, "Suiza", 6, "CHF", "CHE", "CH"));
        entityManager.persist(new Pais(211, "Surinam", 3, "SRD", "SUR", "SR"));
        entityManager.persist(new Pais(212, "Svalbard y Jan Mayen", 6, "NOK", "SJM", "SJ"));
        entityManager.persist(new Pais(213, "Swazilandia", 1, "SZL", "SWZ", "SZ"));
        entityManager.persist(new Pais(214, "Tailandia", 5, "THB", "THA", "TH"));
        entityManager.persist(new Pais(215, "Taiwán", 5, "TWD", "TWN", "TW"));
        entityManager.persist(new Pais(216, "Tanzania", 1, "TZS", "TZA", "TZ"));
        entityManager.persist(new Pais(217, "Tayikistán", 5, "TJS", "TJK", "TJ"));
        entityManager.persist(new Pais(218, "Territorios británicos en el Océano Índico", 5, "GBP", "IOT", "IO"));
        entityManager.persist(new Pais(219, "Timor Oriental", 5, "USD", "", "TL"));
        entityManager.persist(new Pais(220, "Togo", 1, "XOF", "TGO", "TG"));
        entityManager.persist(new Pais(221, "Tokelau", 9, "NZD", "TKL", "TK"));
        entityManager.persist(new Pais(222, "Tonga", 9, "TOP", "TON", "TO"));
        entityManager.persist(new Pais(223, "Trinidad y Tobago", 4, "TTD", "TTO", "TT"));
        entityManager.persist(new Pais(224, "Túnez", 1, "TND", "TUN", "TN"));
        entityManager.persist(new Pais(225, "Turkmenistán", 5, "TMT", "TKM", "TM"));
        entityManager.persist(new Pais(226, "Turquía", 7, "TRY", "TUR", "TR"));
        entityManager.persist(new Pais(227, "Turquía y Caicos", 4, "USD", "TCA", "TC"));
        entityManager.persist(new Pais(228, "Tuvalu", 9, "AUD", "TUV", "TV"));
        entityManager.persist(new Pais(229, "Ucrania", 7, "UAH", "UKR", "UA"));
        entityManager.persist(new Pais(230, "Uganda", 1, "UGX", "UGA", "UG"));
        entityManager.persist(new Pais(231, "Unión Europea", 6, "EUR", "EUR", "EU"));
        entityManager.persist(new Pais(232, "Uruguay", 3, "UYU", "URY", "UY"));
        entityManager.persist(new Pais(233, "Uzbekistán", 5, "UZS", "UZB", "UZ"));
        entityManager.persist(new Pais(234, "Vanuatu", 9, "VUV", "VUT", "VU"));
        entityManager.persist(new Pais(235, "varias islas estadounidenses", 2, "USD", "UMI", "UM"));
        entityManager.persist(new Pais(236, "Venezuela", 3, "VES", "VEN", "VE"));
        entityManager.persist(new Pais(237, "Vietnam", 5, "VND", "VNM", "VN"));
        entityManager.persist(new Pais(238, "Wallis y Futuna", 9, "XPF", "WLF", "WF"));
        entityManager.persist(new Pais(239, "Yemen", 8, "YER", "YEM", "YE"));
        entityManager.persist(new Pais(240, "Yibuti", 1, "DJF", "DJI", "DJ"));
        entityManager.persist(new Pais(241, "Yugoslavia", 7, "YUN", "YUG", "YU"));
        entityManager.persist(new Pais(242, "Zambia", 1, "ZMW", "ZMB", "ZM"));
        entityManager.persist(new Pais(243, "Zimbabue", 1, "ZWL", "ZWE", "ZW"));
    }
}
