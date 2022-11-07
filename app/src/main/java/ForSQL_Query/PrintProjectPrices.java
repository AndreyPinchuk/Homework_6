package ForSQL_Query;

public class PrintProjectPrices {
    private long id;
    private int price;

    public PrintProjectPrices(long id, int price) {
        this.id = id;
        this.price = price;
    }

    public String readPrintProjectPrices(){
        return "ID: "+id+" , Price: "+price;
    }
}
