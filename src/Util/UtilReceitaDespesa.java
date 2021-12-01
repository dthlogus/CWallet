package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilReceitaDespesa {
    
    private static SimpleDateFormat formater = new SimpleDateFormat("dd/MM");
    
    public static Date stringToDateDataDaCompra(String data) throws ParseException{
        return formater.parse(data);
    }
    
}
