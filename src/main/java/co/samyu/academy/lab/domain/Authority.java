package co.samyu.academy.lab.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created on 02/Feb/2017.
 */

@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    @Id
    @NotNull
    @Column(length = 50)
    private String name;

    public Authority() {}

    public Authority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
