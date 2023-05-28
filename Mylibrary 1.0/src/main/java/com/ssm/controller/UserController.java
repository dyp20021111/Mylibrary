package com.ssm.controller;
import com.ssm.pojo.Bookxx;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 依赖注入
     */
    @Autowired
    private UserService userService;

    /**
     * 跳转至登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 用户登录验证
     * @param account 账号
     * @param password 密码
     * @param session 存登录信息
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String login(String account, String password, HttpSession session, Model model){
        User user = userService.getUser(account, password);
        if (user!=null){
            // 在会话中保存登录信息
            session.setAttribute("login", user);
            model.addAttribute("msg", "登录成功,欢迎来到我的图书馆！");
            return "information";
        }
        return "login";
    }
    /*
    toindex
     */
    @RequestMapping("/toindex")
    public String  toindex(){
        return "index";
    }
    @RequestMapping("/tolistBooks")
    public String tolistBooks()
    {
        return "listBooks";
    }

    //删除用户信息
    @RequestMapping("/delUser/{userid}")
    public String deleteUser(@PathVariable int userid) {
        userService.deleteUserById(userid);
        return "redirect:/user/toUserList";
    }
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Model model, Integer userid) {
        User user = userService.queryuserById(userid);
        System.out.println(user);
        model.addAttribute("user",user );
        return "UpdateUser";
    }
    @RequestMapping("/updateUser")

    public String updateUser(Model model, User user) {
        System.out.println(user);
        userService.updateUser(user);
        User c = userService.queryuserById(user.getUserid());
        model.addAttribute("user",c);
        return "redirect:/user/toUserList";
    }

    /**
     *  查询所有的用户信息
     */


    @RequestMapping("/toUserList")
    public String list(Model model){
        List<User> user = userService.listUser();
        for(User b:user){
            System.out.println(b);
        }
        model.addAttribute("user",user);
        return "UserList";
    }


    /**
     * 用户退出登录
     * @param session 登录会话
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    /**
     * 跳转至注册界面/管理员使用时为增加新用户
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    /**
     * 用户注册
     * @param user 用户注册时填的信息
     * @param model
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User user, Model model){
        // 查看是否存在同账号的另一个用户
        User check = userService.findUserByAccount(user.getAccount());
        if (check == null){
            // 判断插入语句执行是否成功
            int affected = userService.addUser(user);
            if (affected > 0){
                model.addAttribute("msg", "注册成功, 你的用户id是 " + user.getUserid());
            } else {
                model.addAttribute("msg", "注册失败, 请重试");
            }
        } else {
            model.addAttribute("msg", "注册失败, 账号已存在");
        }
        return "information";
    }

    /**
     * 查看用户所借书籍信息
     * @param userid
     * @param model
     * @return
     */
    @RequestMapping("/listUserBooks")
    public String listUserBooks(Integer userid, Model model){
        /*
         *  数据库查询会返回很多条同一个用户的记录，只是书本的信息不同
         *  如果用户没有借书，则还会返回null，所以要进行判断
         *  因为最终要呈现到浏览器上的是书本信息，所以只提取books数据即可
         */
        User user = userService.listBooksByUserid(userid);
        if (user != null) {
            model.addAttribute("books", user.getBooks());
        }
        return "userBooks";
    }
    @RequestMapping("/readLibrary")
    public String readLibrary()
    {
        return "readLibrary";
    }
    @RequestMapping("/toReadBook")
    public String toReadLibrary()
    {
        return "ReadBook";
    }
    @RequestMapping("/tozhaohuaxishi")
    public String tozhaohuaxishi()
    {
        return "zhaohuaxishi";
    }
    @RequestMapping("/tohongyan")
    public String tohongyan()
    {
        return "hongyan";
    }
    @RequestMapping("/toPreTable")
    public String toPreTable()
    {
        return "PreTable";
    }
    @RequestMapping("/toConnection")
    public String toConnection()
    {
        return "connection";
    }
    @RequestMapping("/toQuickRead")
    public String toQuickRead()
    {
        return "QuickRead";
    }
    @RequestMapping("/Me")
    public String Me()
    {
        return "MyIntroduction";
    }
    @RequestMapping("/toCheckBook")
    public String toCheckBook()
    {
        return "CheckBook";
    }



}
