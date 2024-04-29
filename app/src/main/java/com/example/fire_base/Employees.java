package com.example.fire_base;

public class Employees {

    private String Name;

    private String Dep;




    public Employees() {

    }


    public Employees(String name,String dep) {
        Name = name;

       Dep=dep;

    }

    public String getName() {
        return Name;
    }

    public String getDep() {
        return Dep;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDep(String dep) {
        Dep = dep;
    }
}
