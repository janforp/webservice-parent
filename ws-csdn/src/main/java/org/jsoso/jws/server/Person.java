package org.jsoso.jws.server;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-24 21:55
 */
public class Person implements Serializable {

    private String name;

    private Integer age;

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
}
