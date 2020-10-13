package academyapi.pojos;

public class Fields {
    private Project project;
    private String summary;
    private String description;
    private Issuetype issuetype;


    public Fields(Project project, String summary, String description, Issuetype issuetype) {
        super();
        this.project = project;
        this.summary = summary;
        this.description = description;
        this.issuetype = issuetype;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    @Override
    public String toString() {
        return "\"fields\":{" + "\n" +
                project.toString() + "\n" +
                ",\"summary\":" + "\"" + summary + '\"' + "\n" +
                ",\"description\":" + "\"" + description + '\"' + "\n" +
                "," + issuetype.toString() + "\n" +
                '}';
    }
}
