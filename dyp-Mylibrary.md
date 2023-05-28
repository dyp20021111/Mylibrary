## <center>java课程设计实验报告</center>

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps9.jpg)



![image-20230528125611838](C:\Users\邓佑朋DM\AppData\Roaming\Typora\typora-user-images\image-20230528125611838.png)

##### 实验原码地址

[Github](https://github.com/dyp20021111/Mylibrary)



#### 一、实验题目

图书管理系统

#### **二、实验目的**

#####      :smiley:  目的在于促进学生复习和巩固计算机软件设计知识，加深对软件设计方法、软件设计技术和设计思想的理解，并能运用所学软件设计知识和WEB工程技术进行综合软件设计，通过本课程设计让学生进行简单WEB应用软件系统的开发，掌握软件设计的方法和面向对象程序设计的基本技术，提高学生在软件开发方面的综合应用能力。

#### 三、实验平台

**装有idea的电脑**

#### 四、实验要求

- #####  实现学生信息的输入

- ##### 实现图书信息的输入

- ##### 实现图书的查询功能

- #####  实现学生信息的查询功能

- #####  实现图书的借出和归还功能

****

#### 五、设计思路和流程

##### （1）.我首先是配置资源和数据。引入pom文件，整合ssm配置资源。配置application-dao.xml,application-service.xml,applicationContext.xml，

##### datebases.propertis,mybatis-config.xml,spring-mvc.xml。然后创建前端模块webapp以及引入jquery和配置web.xml。

##### （2）.第二步是进行ssm框架整合，即搭建平台。创建controller,dao,service,pojo层，以及拦截器的实现类。ssm框架有book和user二者的持久实现及业务逻辑部分！

##### （3）.最后就是具体各个功能的实现！

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps1.jpg)

​    







### 六、实验关键代码

##### BookController

~~~
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserAndBookService userAndBookService;
    /**
     * 显示所有书目信息的接口
     * @param model
     * @return
     */
/**
  *搜索查询书籍方法
 */
    @RequestMapping(value = "/listBooks")
    //使用传参的方式
    public String listBooks(Model model, HttpServletRequest request) {
        String bookname = request.getParameter("bookname");
        System.out.println(bookname);
           //判断通过点击按钮有没有把bookname的数据传回到这个方法里来,这里判断注意加上判断空格，因为输入一次数据以后会带上空格
            if(bookname==null||bookname=="") {
                //不输入内容的话点击查询就是输出全部书籍信息
                List<Bookxx> books = bookService.listBooks();
                model.addAttribute("books", books);
                return "listBooks";
            }else{
                //按传入的bookname查询，把查询书籍结果放入数组里面
                Bookxx book = bookService.findBookByName(bookname);
                List<Bookxx> books=new ArrayList<Bookxx>();
                books.add(book);
                System.out.println(books);
                model.addAttribute("books", books);//传回数据到模型
                return "listBooks";
            }
    }
    /**
     * 根据id删除特定书目
     * @param bookid
     * @param model
     * @return
     */
    @GetMapping("/delBook")
    @Transactional
    public String delBook(@RequestParam("bookid") Integer bookid,Model model)
    {
      int affected=bookService.delBool(bookid);
      if(affected>0)
      {
          model.addAttribute("msg","成功删除id为"+bookid+"的书：");
      }
      else
      {
          model.addAttribute("msg","删除失败");
      }
      return "redirect:/book/listBooks";
    }
    /**
     * 转到更新书目信息
     * @param model
     * @param bookid
     * @return
     */
    @RequestMapping("/toUpdateBook/{bookid}")
    public String toUpdateBook(Model model, @PathVariable Integer bookid)
    {
        model.addAttribute("bookid",bookid);
        return "updateBook";
    }
    /**
     * 更新书目信息
     * @param book 需要更新的书的新信息
     * @param model
     * @return
     */
    @PostMapping("updateBook")
    @Transactional
    public String updateBook(Bookxx book, Model model)
    {
       int affected=bookService.updateBook(book);
       if(affected>0)
       {
           model.addAttribute("msg","更新成功");
       }
       else
       {
           model.addAttribute("msg","更新失败");
       }
       return "information";
    }
    /**
     * 用户借书
     * @param request json格式信息，包括bookid和userid
     * @return response json格式信息，包括info
     */
    @RequestMapping("/borrowBook")
    @ResponseBody
    @Transactional
    public  Map<String,String> borrowBook(@RequestBody Map<String,String> request)
    {
     int bookid=Integer.parseInt(request.get("bookid"));
     int userid=Integer.parseInt(request.get("userid"));
     Map<String,String> response=new HashMap<>(1);
     //判断是否存在借过此书的记录
        Integer ifBorrow= userAndBookService.checkIfBorrow(bookid,userid);
        if(ifBorrow!=null)
        {
            response.put("info","借书失败，你已借过此书");
        }
        else
        {
            bookService.borrowBook(bookid);
            userAndBookService.borrowBook(bookid, userid);
            response.put("info","借书成功");
        }
        return response;
    }
    /**
     * 用户还书
     * @param request json格式信息，包括bookid和userid
     * @return response json格式信息，包括info
     */
    @RequestMapping("/returnBook")
    @ResponseBody
    @Transactional
    public Map<String,String> returnBook(@RequestBody Map<String,String> request)
    {
        int bookid=Integer.parseInt(request.get("bookid"));
        int userid=Integer.parseInt(request.get("userid"));
        Map<String ,String> response=new HashMap<>(1);
        userAndBookService.returnBook(bookid,userid);
        bookService.returnBook(bookid);
        response.put("info","还书成功");
        return response;
    }

}
~~~

##### UserController

~~~
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
     * 跳转至注册界面/管理员使用时为增加新用户
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
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
@RequestMapping("/toCheckBook")
    public String toCheckBook()
    {
        return "CheckBook";
    }
}
~~~

### 七、实验结果部分展示

##### 1.用户登录成功后的主页

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps2.jpg)

##### 2.用户的书籍列表，可以进行借书，搜索书籍。



![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps3.jpg)

##### 3.借书成功

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps4.jpg)



##### 4.快速阅读界面

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps5.jpg)



##### 5.推荐书目导读

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps6.jpg)



#####  6.查询用户

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps7.jpg)

##### 7.注册界面

![img](file:///C:\Users\邓佑朋DM\AppData\Local\Temp\ksohtml2016\wps8.jpg)

##### 本系统由于功能太多，就不一一展示啦！

### 八、实验体会

#####        首先完成课设作业的心情是开心喜悦的。在这次课设过程中遇到了些许问题，解决起来有点繁琐，不过也学到和巩固了前后端知识。在开发的过程中虽然很艰辛，但能在这个过程中不断的锤炼自己的能力，提高自己的编程能力，还是挺值得的！希望自己在接下来的学习过程中，可以继续保持课设时候的探索和坚持精神，继续努力的学习，提高自己的综合能力和专业素养吧！**:smile:**

