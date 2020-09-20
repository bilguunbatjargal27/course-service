package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.*;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;//
    private String zipCode;
}
