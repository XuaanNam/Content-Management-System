package model;

public class Account {
    public static int userId = -1;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String description;
    private String createdate;
    private String updatetime;

    
    public Account( ){
        
    }
    public Account(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}

    
    public Account(int userId, String fname, String lname, String email, String phone, String description,
            String updatetime) {
        super();
        Account.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.updatetime = updatetime;
    }

    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

}