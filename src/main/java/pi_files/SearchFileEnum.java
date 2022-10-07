package pi_files;

public enum SearchFileEnum {
    ONETHOUSANDURL("One thousand pi digits from Internet", 1000),
    ONETHOUSANDFILE("One thousand pi digits from local file (in case it exists)", 1000),
    ONEMILLIONURL("One million pi digits from Internet", 1000000),
    ONEMILLIONFILE("One million pi digits from local file (in case it exists)", 1000000),
    ONEBILLIONURL("One billion pi digits from Internet", 1000000000),
    ONEBILLIONFILE("One billion pi digits from local file (in case it exists)", 1000000000);
    private SearchFileEnum(String descrip, int size){
        this.descrip = descrip;
        this.size = size;
    }
    private String descrip;
    private int size;

    private String getDescrip() {
        return descrip;
    }
    public static SearchFileEnum getOpcion(int num){
        return values()[num];
    }

    public static int getIndex(SearchFileEnum sf){
        for(int i = 0; i < values().length; i++){
            if(sf.equals(values()[i])) return i;
        }
        return -1;
    }

    public static String getOpciones(){
        StringBuilder sb = new StringBuilder();
        sb.append("Select the file option: \n");
        for(int i = 0; i < values().length; i++){
            sb.append( i + ". " + getOpcion(i).getDescrip() + "\n");
        }
        return sb.toString();
    }
    public static int getSize(int num){return values()[num].size;}
}
