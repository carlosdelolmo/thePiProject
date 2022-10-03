package org.example;

import java.io.File;

public class SingletonPiFile {
    private static final SingletonPiFile Singleton = new SingletonPiFile();
    private static File oneBillionPiDigits;
    private static File oneMillionPiDigits;
    private static File oneThousandPiDigits;
    private SingletonPiFile(){
        oneBillionPiDigits = new File("name");
        oneMillionPiDigits = new File("name");
        oneThousandPiDigits = new File("name");
    }
    public static File getBFile(){
        return oneBillionPiDigits;
    }
    public static File getMFile(){
        return oneMillionPiDigits;
    }
    public static File getTFile(){
        return oneThousandPiDigits;
    }
}
