
public class JobListingModel {
    private String jobTitle;
    private String jobDescription;
    private String companyName;
    private String location;
    private String websiteLink;

    public JobListingModel() {
        // Default constructor required for calls to DataSnapshot.getValue(JobListingModel.class)
    }

    public JobListingModel(String jobTitle, String jobDescription, String companyName, String location, String websiteLink) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.location = location;
        this.websiteLink = websiteLink;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }
}
