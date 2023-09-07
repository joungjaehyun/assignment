package com.example.assignment.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_account")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(unique=true)
    private String email;

    private String pw;

    private String intro;

    private boolean delFlag;

    private String address;



    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeIntro(String intro){
        this.intro = intro;
    }

    public void delete(){
        this.delFlag = true;
    }

    public void changeAddress(String address){
        this.address = address;
    }
    

}