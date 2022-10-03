public enum SearchFileSelection {
    ONETHOUSANDURL("One thousand pi digits form Internet"),
    ONEMILLIONURL("One million pi digits from Internet"),
    ONEBILLIONURL("One billion pi digits from Internet"),
    ONEBILLIONFILE("One billion pi digits from local file (in case it exists)");
    private SearchFileSelection(String descrip){
        this.descrip = descrip;
    }
    private String descrip;

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
}
