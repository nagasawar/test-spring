package testspring.app.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ユーザ
 */
@Controller
@RequestMapping("users")
public class UserController {

    @ModelAttribute
    public UserForm setupForm() {
        UserForm form = new UserForm();
        return form;
    }

    /**
     * ユーザ一覧[表示]
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    String userList() {
        return "user/list";
    }

    /**
     * 新規登録[表示]
     * @return
     */
    @RequestMapping(path="addNew", method = RequestMethod.GET)
    String addNew() {
        return "user/addNew";
    }

    /**
     * 新規作成[実行]
     * @return
     */
    @RequestMapping(path="create", method = RequestMethod.POST)
    String create() {
        return "user/addNew";
    }

    /**
     * 詳細[表示]
     * @return
     */
    @RequestMapping(path="{userId}/details", method = RequestMethod.GET)
    String details() {
        return "user/details";
    }

    /**
     * 編集[表示]
     * @return
     */
    @RequestMapping(path="{userId}/edit", method = RequestMethod.GET)
    String edit() {
        return "user/edit";
    }

    /**
     * 更新[実行]
     * @return
     */
    @RequestMapping(path="{userId}/update", method = RequestMethod.POST)
    String update() {
        return "user/edit";
    }

    /**
     * 削除[実行]
     * @return
     */
    @RequestMapping(path="{userId}/delete", method = RequestMethod.POST)
    String delete() {
        return "user/edit";
    }
}