package testspring.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping()
    String list(AccountForm form, Model model) {

        // 検索条件セット
        AccountCriteria criteria = new AccountCriteria();
        criteria.setAccountId(form.getAccountId());
        criteria.setAccountName(form.getAccountName());

        // 検索実行
        List<Account> accounts = accountMapper.findByCriteria(criteria);

        // 画面へセット
        model.addAttribute("accounts", accounts);

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