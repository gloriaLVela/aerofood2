package com.codeup.aerofood.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(nullable = false, unique=true,  columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(nullable = false, unique=true, columnDefinition = "VARCHAR(10)")
    @Size(min=10, max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone_number;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Orders> orders;

    public User() {}

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        this.phone_number = copy.phone_number;
        this.orders = copy.orders;
    }

    public User(String username,
                String email,
                String phone_number,
                String password,
                List<Orders> orders) {
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
