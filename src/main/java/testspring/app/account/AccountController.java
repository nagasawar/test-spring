package testspring.app.account;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    String create(@Valid AccountForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "account/addNew";
        }

        Account account = new Account();
        BeanUtils.copyProperties(form, account);
        account.setAccountRoleId(1);

        accountMapper.create(account);

        return "redirect:/accounts/create?complete";
    }

    /**
     * 新規作成[完了]
     * @return
     */
    @RequestMapping(path="create", method = RequestMethod.GET, params = "complete")
    String createComplete() {
        return "/account/createComplete";
    }

    /**
     * 詳細[表示]
     * @return
     */
    @RequestMapping(path="{accountId}", method = RequestMethod.GET)
    String details(@PathVariable("accountId") String accountId, Model model) {

        Account account = accountMapper.getOne(accountId);

        if (StringUtils.isEmpty(account)) {
            model.addAttribute("errorMessage", "対象のアカウントが存在しません");
            return "error/berror";
        }

        model.addAttribute("account", account);

        return "account/details";
    }

    /**
     * 編集[表示]
     * @return
     */
    @RequestMapping(path="{accountId}/edit", method = RequestMethod.GET)
    String edit(@PathVariable("accountId") String accountId, Model model) {

        Account account = accountMapper.getOne(accountId);

        if (StringUtils.isEmpty(account)) {
            model.addAttribute("errorMessage", "対象のアカウントが存在しません");
            return "error/berror";
        }

        AccountForm form = new AccountForm();
        BeanUtils.copyProperties(account, form);
        model.addAttribute(form);

        return "account/edit";
    }

    /**
     * 更新[実行]
     * @return
     */
    @RequestMapping(path="{accountId}/update", method = RequestMethod.POST)
    String update(@Valid AccountForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "account/edit";
        }

        Account account = new Account();
        BeanUtils.copyProperties(form, account);
        account.setAccountRoleId(1);

        accountMapper.update(account);

        return "redirect:";
    }

    /**
     * 削除[実行]
     * @return
     */
    @RequestMapping(path="{accountId}/delete", method = RequestMethod.GET)
    String delete(@PathVariable("accountId") String accountId, Model model) {

        Account account = accountMapper.getOne(accountId);

        if (StringUtils.isEmpty(account)) {
            model.addAttribute("errorMessage", "対象のアカウントが存在しません");
            return "error/berror";
        }

        accountMapper.delete(accountId);

        return "redirect:/accounts";
    }
}