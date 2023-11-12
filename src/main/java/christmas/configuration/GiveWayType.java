package christmas.configuration;

public enum GiveWayType {
    GIVE_WAY("샴페인",1);

    private final String giveWay;
    private final int count;

    GiveWayType(String giveWay, int count) {
        this.giveWay = giveWay;
        this.count = count;
    }

    public String getGiveWay() {
        return giveWay;
    }

    public int getCount() {
        return count;
    }
}
