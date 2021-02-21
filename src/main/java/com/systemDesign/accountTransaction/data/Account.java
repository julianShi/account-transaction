package com.systemDesign.accountTransaction.data;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Check(constraints = "balance >= 0")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer balance;

    public void setId(Integer id) {this.id = id;}

    public void setBalance(Integer balance) {this.balance = balance;}

    public Integer getId() {return this.id;}

    public Integer getBalance() {return this.balance;}
}
