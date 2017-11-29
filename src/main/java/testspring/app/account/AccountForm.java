package testspring.app.account;

import java.io.Serializable;

public class AccountForm implements Serializable {
    private static final long serialVersionUID = -8656573892796834588L;

    private String accountId;
    private String password;
    private String accountName;

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
}