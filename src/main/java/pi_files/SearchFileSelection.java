package pi_files;

public enum SearchFileSelection {
    ONETHOUSANDURL("One thousand pi digits from Internet", 1000),
    ONEMILLIONURL("One million pi digits from Internet", 1000000),
    ONEBILLIONURL("One billion pi digits from Internet", 1000000000),
    ONEBILLIONFILE("One billion pi digits from local file (in case it exists)", 1000000000);
    private SearchFileSelection(String descrip, int size){
        this.descrip = descrip;
        this.size = size;
    }
    private String descrip;
    private int size;

    private String getDescrip() {
        return descrip;
    }
    public static SearchFileSelection getOpcion(int num){
        return values()[num];
    }

    public static String getOpciones(){
        StringBuilder sb = new StringBuilder();
        sb.append("Select the file option: \n");
        for(int i = 0; i < values().length; i++){
            sb.append( i + ". " + getOpcion(i).getDescrip() + "\n");
        }
        return sb.toString();
    }
    public int getSize(){
        return size;
    }
}
