package christmas.configuration;

public enum BadgeType {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 2000),
    NONE_BADGE("없음", 0);

    private final String badge;
    private final int benefit;

    BadgeType(String badge, int benefit) {
        this.badge = badge;
        this.benefit = benefit;
    }

    public String getBadge() {
        return badge;
    }

    public int getBenefit() {
        return benefit;
    }


}
