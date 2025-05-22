package ac.cr.ucr.creativeSpaces.model;

public class User
{
    private Integer id;
    private String name;
    private Integer age;
    private String telephone;
    private String email;


    public User()
    {

    }

    public User(Integer id, String name, Integer age, String telephone, String email)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
