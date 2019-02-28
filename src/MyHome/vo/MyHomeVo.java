package MyHome.vo;

import java.sql.Date;

public class MyHomeVo {
    private Long no;
    private String name;
    private String password;
    private String email;
    private Character gender;
    private Date created_at;

    //생성자1
    public MyHomeVo(String name, String password, String email, Character gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }
    //생성자2
    public MyHomeVo(Long no, String name, String password, String email, Character gender, Date created_at) {
        this.no = no;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.created_at = created_at;
    }
    //toString


    @Override
    public String toString() {
        return "MyHomeVo{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", created_at=" + created_at +
                '}';
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
