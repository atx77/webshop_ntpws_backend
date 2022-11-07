package hr.tvz.diplomski.webshop_ntpws.enumeration;

public enum CountryEnum {
    CROATIA("Hrvatska");

    private String description;

    CountryEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
