package pi_files;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderFactory {
    public BufferedReader getBufferedReader(int num) throws IOException {
        BufferedReader wantedBufferedReader;
        SearchFileEnum wantedFile = SearchFileEnum.getOpcion(num);
        wantedBufferedReader = switch (wantedFile){
            case ONEBILLIONURL -> SingletonPiFile.getBPiDigits();
            case ONEBILLIONFILE -> SingletonPiFile.getBPiDigitsFromFile();
            case ONEMILLIONURL -> SingletonPiFile.getMPiDigits();
            case ONEMILLIONFILE -> SingletonPiFile.getMPiDigitsFromFile();
            case ONETHOUSANDURL -> SingletonPiFile.getThPiDigits();
            case ONETHOUSANDFILE -> SingletonPiFile.getThPiDigitsFile();
        };
        return wantedBufferedReader;
    }
}
