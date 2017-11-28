package testspring.mapper;

/**
 * アカウント検索条件
 */
public class AccountCriteria {
    private String accountId;
    private String accountName;

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
