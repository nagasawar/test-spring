package testspring.domain;

import lombok.Data;

@Data
public class Account {
    private String accountId;
    private String password;
    private String accountName;
    private Integer accountRoleId;
}
