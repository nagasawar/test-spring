package testspring.app.account;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class AccountForm implements Serializable {
    private static final long serialVersionUID = -8656573892796834588L;

    //TODO 半角英数字
    //TODO 半角文字の最大数
    @NotEmpty
    @Size(max = 20)
    private String accountId;

    //TODO 半角英数字
    //TODO 半角文字の最大数
    @NotEmpty
    @Size(max = 255)
    private String password;

    //TODO バイトの最大数
    @NotEmpty
    @Size(max = 100)
    private String accountName;
}