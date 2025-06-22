package ac.cr.ucr.creativeSpaces.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 10)
    private Integer id;
    @Column(name = "name", nullable = false, length = 70)
    private String name;
    @Column(name = "age", nullable = false, length = 10)
    private Integer age;
    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "password", nullable = false, length = 150)
    private String password;


    public User()
    {
        this.id=0;
    }

    public User(Integer id, String name, Integer age, String telephone, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
