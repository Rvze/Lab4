public enum Place {
    GORGE ("gorge"),
    WATER ("water"),
    UNKNOWN ("unknown"),
    OVER_THERE("over there",100, 100),
    ISLAND ("island");

    public String url;
    private final int x;
    private final int y;
    private final int len = Integer.MAX_VALUE;
    private final int defaulElectricCharge = 12345;
    private int electricCharge=defaulElectricCharge;

    Place(String url) {
        this.url = url;
        x = (int) (Math.random() * len);
        y = (int) (Math.random() * len);
    }

    Place(String url, int x, int y) {
        this.url = url;
        this.x = x;
        this.y = y;
    }

    public void addElectricCharge(int electricCharge) {
        if(this.electricCharge+electricCharge>0)
            this.electricCharge = this.electricCharge+electricCharge;
    }

    public String getUrl() {
        return url;
    }

    public int getElectricCharge() {
        return electricCharge;
    }
}