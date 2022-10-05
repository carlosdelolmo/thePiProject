package tools;

import java.text.Normalizer;
import java.util.HashSet;

public class StringToNumberConversor {
    public StringToNumberConversor(){}
    public String numberize(String stringToNumberize){
        stringToNumberize = cleanString(stringToNumberize);
        StringBuilder result = new StringBuilder();
        char[] c = stringToNumberize.toCharArray();
        HashSet <Character> numberSet = generateNumberSet();
        for (Character ss : c)
            if(numberSet.contains(ss)) result.append(ss);
            else result.append(ss - 'a' + 1);
        return result.toString();
    }
    private HashSet<Character> generateNumberSet(){
        HashSet<Character> numberSet= new HashSet<>();
        for(int i = 0; i < 10; i++){
            char j = (char)( i + '0');
            numberSet.add(j);
        }
        return numberSet;
    }
    private String cleanString(String cadena) {
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        cadena = cadena.replace(" ", "");
        return cadena.toLowerCase();
    }
}