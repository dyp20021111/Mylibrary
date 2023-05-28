package com.ssm.controller;
import com.ssm.pojo.Bookxx;
import com.ssm.service.BookService;
import com.ssm.service.UserAndBookService;
import org.apache.ibatis.annotations.Param;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  *查询方法
 */
@RequestMapping("/tocheckBooks")
public String toCheckBooks(Model model) {
    List<Bookxx> books=null;
    model.addAttribute("books",books);
    return "redirect:/book/listBooks";
}


    @RequestMapping("/listBooks")
    public String listBooks(Model model, HttpServletRequest request)
    {
           String bookname=request.getParameter("bookname");
            if(bookname==null) {
                System.out.println(bookname);
                List<Bookxx> books = bookService.listBooks();
                model.addAttribute("books", books);
                return "listBooks";
            }else{
                System.out.println(bookname);
                Bookxx book = bookService.findBookByName(bookname);
                System.out.println(book);
                List<Bookxx> books=new ArrayList<Bookxx>();
                books.add(book);
                System.out.println(books);
                model.addAttribute("books", books);
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
    /**转到添加书目信息的界面
     * @return
     */
    @RequestMapping("/toAddBook")
    public String toAddBook()
    {
        return "addBook";
    }

    /**
     * 添加新书
     * @param book 新书的信息
     * param model
     * return
     */
    @PostMapping("/addBook")
    public String addBook(Bookxx book,Model model)
    {
        //查看是否存在同名的书籍(不许同名的书籍存在)
        Bookxx check=bookService.findBookByName(book.getBookname());
        if(check!=null)
        {
            model.addAttribute("msg","添加失败，已存在同名的书籍");
        }
        else
        {
            int affected=bookService.addBook(book);
            if(affected>0)
            {
                model.addAttribute("msg","添加成功，新的书目的id为"+book.getBookid());
            }
            else
            {
                model.addAttribute("msg","添加失败");
            }

        }
        return  "information";
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
     * 按名字查询书籍
     * @param bookname
     * @return
     */
    @RequestMapping("/findBookByName")
    @ResponseBody
    @Transactional
    public String findBookByName(@PathVariable String bookname)
    {
        bookService.findBookByName(bookname);
        return "listBooks";
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
