package testspring.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testspring.domain.User;
import testspring.mapper.UserCriteria;
import testspring.mapper.UserMapper;

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

    @Autowired
    UserMapper userMapper;

    /**
     * ユーザ一覧[表示]
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    String userList() {

        // ユーザ単一
        User user = userMapper.getOne("10001");
        System.out.println("userId: " + user.getUserId());
        System.out.println("password: " + user.getPassword());
        System.out.println("userName: " + user.getUserName());
        System.out.println("userRoleId: " + user.getUserRoleId());

        // ユーザ全件
        List<User> users = userMapper.findAll();
        for (User u : users) {
            System.out.println("@userId: " + u.getUserId());
            System.out.println("@password: " + u.getPassword());
            System.out.println("@userName: " + u.getUserName());
            System.out.println("@userRoleId: " + u.getUserRoleId());
        }

        // ユーザ検索条件
        UserCriteria criteria = new UserCriteria();
        criteria.setUserId("10002");
        //criteria.setUserName("山田");

        List<User> users2 = userMapper.findByCriteria(criteria);
        for (User u : users2) {
            System.out.println("#userId: " + u.getUserId());
            System.out.println("#password: " + u.getPassword());
            System.out.println("#userName: " + u.getUserName());
            System.out.println("#userRoleId: " + u.getUserRoleId());
        }

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