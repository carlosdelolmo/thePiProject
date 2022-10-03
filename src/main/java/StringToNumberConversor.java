import java.text.Normalizer;

public class StringToNumberConversor {
    public StringToNumberConversor(){}
    public String numberize(String stringToNumberize){
        stringToNumberize = cleanString(stringToNumberize);
        System.out.println(stringToNumberize);
        String result = "";
        char[] c = stringToNumberize.toCharArray();
        for (Character ss : c)
            result += (ss - 'a' + 1);
        return result;
    }
    private String cleanString(String cadena) {
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        cadena = cadena.replace(" ", "");
        return cadena.toLowerCase();
    }
}
