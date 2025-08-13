package makingAdifference;

public class Emergency {
    private String reporterName;
    private String reporterPhoneNumber;
    private String location;
    private String natureOfEmergency;
    private String typeOfResponse;
    private String statusOfResponse;
    private String timeOfReport;
    private String emergencyId;

    public Emergency(String reporterName, String reporterPhoneNumber, String location, String natureOfEmergency) {
        this.reporterName = reporterName;
        this.reporterPhoneNumber = reporterPhoneNumber;
        this.location = location;
        this.natureOfEmergency = natureOfEmergency;
        this.timeOfReport = java.time.LocalDateTime.now().toString();
        this.emergencyId = java.util.UUID.randomUUID().toString();
        this.typeOfResponse = "";
        this.statusOfResponse = "Unresolved";
    }

    public void setTypeOfResponse(String typeOfResponse) {
        this.typeOfResponse = typeOfResponse;
    }

    public void setStatusOfResponse(String statusOfResponse) {
        this.statusOfResponse = statusOfResponse;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getReporterPhoneNumber() {
        return reporterPhoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getNatureOfEmergency() {
        return natureOfEmergency;
    }

    public String getTypeOfResponse() {
        return typeOfResponse;
    }

    public String getStatusOfResponse() {
        return statusOfResponse;
    }

    public String getTimeOfReport() {
        return timeOfReport;
    }

    public String getEmergencyId() {
        return emergencyId;
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "reporterName='" + reporterName + '\'' +
                ", reporterPhoneNumber='" + reporterPhoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", natureOfEmergency='" + natureOfEmergency + '\'' +
                ", typeOfResponse='" + typeOfResponse + '\'' +
                ", statusOfResponse='" + statusOfResponse + '\'' +
                ", timeOfReport='" + timeOfReport + '\'' +
                ", emergencyId='" + emergencyId + '\'' +
                '}';
    }

    public void displayEmergencyDetails() {
        System.out.println("Emergency ID: " + emergencyId);
        System.out.println("Reporter Name: " + reporterName);
        System.out.println("Reporter Phone Number: " + reporterPhoneNumber);
        System.out.println("Location: " + location);
        System.out.println("Nature of Emergency: " + natureOfEmergency);
        System.out.println("Type of Response: " + typeOfResponse);
        System.out.println("Status of Response: " + statusOfResponse);
        System.out.println("Time of Report: " + timeOfReport);
    }

    public static void main(String[] args) {
        Emergency emergency = new Emergency("John Doe", "123-456-7890", "123 Main St", "Fire");
        emergency.setTypeOfResponse("Fire Department");
        emergency.setStatusOfResponse("In Progress");
        emergency.displayEmergencyDetails();
    }
}
