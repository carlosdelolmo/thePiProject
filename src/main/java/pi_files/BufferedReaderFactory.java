package pi_files;

import pi_files.SearchFileSelection;
import pi_files.SingletonPiFile;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderFactory {
    public BufferedReader getBufferedReader(int num) throws IOException {
        BufferedReader wantedBufferedReader = null;
        SearchFileSelection wantedFile = SearchFileSelection.getOpcion(num);
        wantedBufferedReader = switch (wantedFile){
            case ONEBILLIONURL -> SingletonPiFile.getBPiDigits();
            case ONEBILLIONFILE -> SingletonPiFile.getBPiDigitsFromFile();
            case ONEMILLIONURL -> SingletonPiFile.getMPiDigits();
            case ONETHOUSANDURL -> SingletonPiFile.getThPiDigits();
        };
        return wantedBufferedReader;
    }
}
