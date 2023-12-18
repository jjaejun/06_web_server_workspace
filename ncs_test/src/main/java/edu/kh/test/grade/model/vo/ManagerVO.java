package edu.kh.test.grade.model.vo;

public class ManagerVO {
    private String managerNumber;
    private String managerName;
    private String managerHireDate;

    public ManagerVO() {}

    public ManagerVO(String managerNumber, String managerName, String managerHireDate) {
        this.managerNumber = managerNumber;
        this.managerName = managerName;
        this.managerHireDate = managerHireDate;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerHireDate() {
        return managerHireDate;
    }

    public void setManagerHireDate(String managerHireDate) {
        this.managerHireDate = managerHireDate;
    }
}
