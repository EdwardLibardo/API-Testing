package academyapi.pojos;

public class Issuetype {

    public Issuetype(String name) {
        super();
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\"issuetype\":{" + "\n" +
                "\"name\":" + "\"" + name + '\"' + "\n" +
                "}";
    }
}

