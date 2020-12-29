package views.dialogs;

public class WorkerData {
    private String name;
    private String phone;
    private String birth;
    private String hire;

    WorkerData(String name, String phone, String birth, String hire) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.hire = hire;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    public String getHire() {
        return hire;
    }
}
