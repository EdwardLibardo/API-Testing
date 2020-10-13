package academyapi.pojos;

public class Project {
    private String key;

    public Project(String key) {
        super();
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "\"project\":\n{" + "\n" +
                "\"key\":" + "\"" + key + '\"' + "\n" +
                '}';
    }
}
