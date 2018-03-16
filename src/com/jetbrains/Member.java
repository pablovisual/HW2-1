package com.jetbrains;

public class Member
{
    private String ID;
    private String PW; //password
    private String firstName;
    private String lastName;
    private String Email;

    public Member(String id, String Pass, String FN, String LN, String email)
    {
        //set variables based on parameters.
        ID = id;
        PW = Pass;
        firstName = FN;
        lastName = LN;
        Email = email;
    }

    //public void setID(String ID) { this.ID = ID; }
    public String getID() { return this.ID; }
    //public void setPW(String PW) { this.PW = PW; }
    public String getPW() { return this.PW; }
    //public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return this.firstName; }
    //public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return this.lastName; }
    //public void setEmail(String email) { Email = email; }
    public String getEmail() { return this.Email; }
}