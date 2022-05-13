package htw.berlin.webtech.WebTech.web.api;

public class Plant {
    private long id;
    private String commonName;
    private String botanicalName;
    private boolean saved;

    public Plant(long id, String commonName, String botanicalName, boolean saved) {
        this.id = id;
        this.commonName = commonName;
        this.botanicalName = botanicalName;
        this.saved = saved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
