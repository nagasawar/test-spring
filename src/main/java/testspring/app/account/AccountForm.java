package testspring.app.account;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import common.validation.AlphaNumeric;
//import lombok.Data;
import lombok.*;

@Data
public class AccountForm implements Serializable {
    private static final long serialVersionUID = -8656573892796834588L;

    @NotEmpty
    @AlphaNumeric
    @Size(max = 20)
    private String accountId;

    @NotEmpty
    @AlphaNumeric
    @Size(max = 255)
    private String password;

    @NotEmpty
    @Size(max = 30)
    private String accountName;
}