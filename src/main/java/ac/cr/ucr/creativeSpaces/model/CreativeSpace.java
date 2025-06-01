package ac.cr.ucr.creativeSpaces.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_creativeSpace")
public class CreativeSpace
{
    @Id
    private Integer id;
    private Integer day;
    private String type;
    private String location;
    private String membership;
    private String payment;
    private String review;

    public CreativeSpace()
    {
        this.id=0;
    }

    public CreativeSpace(Integer id, Integer day, String type, String location, String membership, String payment, String review) {
        this.id = id;
        this.day = day;
        this.type = type;
        this.location = location;
        this.membership = membership;
        this.payment = payment;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
