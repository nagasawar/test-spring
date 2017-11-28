package testspring.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testspring.domain.Account;
import testspring.mapper.AccountCriteria;
import testspring.mapper.AccountMapper;

/**
 * アカウント
 */
@Controller
@RequestMapping("accounts")
public class AccountController {

    @ModelAttribute
    public AccountForm setupForm() {
        AccountForm form = new AccountForm();
        return form;
    }

    @Autowired
    AccountMapper accountMapper;

    /**
     * アカウント一覧[表示]
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    String accountList() {

        // アカウント単一
        Account account = accountMapper.getOne("10001");
        System.out.println("accountId: " + account.getAccountId());
        System.out.println("password: " + account.getPassword());
        System.out.println("accountName: " + account.getAccountName());
        System.out.println("accountRoleId: " + account.getAccountRoleId());

        // アカウント全件
        List<Account> accounts = accountMapper.findAll();
        for (Account u : accounts) {
            System.out.println("@accountId: " + u.getAccountId());
            System.out.println("@password: " + u.getPassword());
            System.out.println("@accountName: " + u.getAccountName());
            System.out.println("@accountRoleId: " + u.getAccountRoleId());
        }

        // アカウント検索条件
        AccountCriteria criteria = new AccountCriteria();
        criteria.setAccountId("10002");
        //criteria.setAccountName("山田");

        List<Account> accounts2 = accountMapper.findByCriteria(criteria);
        for (Account u : accounts2) {
            System.out.println("#accountId: " + u.getAccountId());
            System.out.println("#password: " + u.getPassword());
            System.out.println("#accountName: " + u.getAccountName());
            System.out.println("#accountRoleId: " + u.getAccountRoleId());
        }

        return "account/list";
    }

    /**
     * 新規登録[表示]
     * @return
     */
    @RequestMapping(path="addNew", method = RequestMethod.GET)
    String addNew() {
        return "account/addNew";
    }

    /**
     * 新規作成[実行]
     * @return
     */
    @RequestMapping(path="create", method = RequestMethod.POST)
    String create() {
        return "account/addNew";
    }

    /**
     * 詳細[表示]
     * @return
     */
    @RequestMapping(path="{accountId}/details", method = RequestMethod.GET)
    String details() {
        return "account/details";
    }

    /**
     * 編集[表示]
     * @return
     */
    @RequestMapping(path="{accountId}/edit", method = RequestMethod.GET)
    String edit() {
        return "account/edit";
    }

    /**
     * 更新[実行]
     * @return
     */
    @RequestMapping(path="{accountId}/update", method = RequestMethod.POST)
    String update() {
        return "account/edit";
    }

    /**
     * 削除[実行]
     * @return
     */
    @RequestMapping(path="{accountId}/delete", method = RequestMethod.POST)
    String delete() {
        return "account/edit";
    }
}