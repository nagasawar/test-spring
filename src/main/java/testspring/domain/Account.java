package testspring.domain;

public class Account {
    private String accountId;
    private String password;
    private String accountName;
    private Integer accountRoleId;

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Integer getAccountRoleId() {
        return accountRoleId;
    }
    public void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }
}
