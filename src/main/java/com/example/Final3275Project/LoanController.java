package com.example.Final3275Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SessionAttributes({"id","name","amount", "years", "type", "errMsg","errorMessage"})
@RequestMapping
@Controller
public class LoanController {

    DatabaseService service1;
    @Autowired
    LoanService service;
    @Autowired
    Connection1 connect1;

    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public String showLoanpage(ModelMap model,@RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect1.connect());
        model.addAttribute("todos", service1.display());
        List<Loan> filteredTodos = new ArrayList<Loan>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getClientno());
        model.put("name",filteredTodos.get(0).getClientname());
        model.put("amount",filteredTodos.get(0).getLoanamount());
        model.put("years",filteredTodos.get(0).getYears());
        model.put("type",filteredTodos.get(0).getLoantype());
        return "loan";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoanPage2(ModelMap model) throws ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect1.connect());
        model.addAttribute("todos", service1.display());
        List<Loan> filteredTodos = new ArrayList<Loan>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getClientno());
        model.put("name",filteredTodos.get(0).getClientname());
        model.put("amount",filteredTodos.get(0).getLoanamount());
        model.put("years",filteredTodos.get(0).getYears());
        model.put("type",filteredTodos.get(0).getLoantype());
        return "loan";
    }
    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "loanadd";
    }
    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String clientno, @RequestParam String clientname,
    @RequestParam double loanamount, @RequestParam int years, @RequestParam String loantype)
            throws SQLException, ClassNotFoundException {
        if (!((service1.search(clientno)) ==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/loan";
        }
        Loan ll = new Loan(clientno,clientname, loanamount, years, loantype);
        service1.add(ll);
        model.clear();
        return "redirect:/loan";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws SQLException, ClassNotFoundException {
        model.put("id", id);
        Loan ll = service1.search(id);
        model.put("id",ll.getClientno());
        model.put("name",ll.getClientname());
        model.put("amount",ll.getLoanamount());
        model.put("years",ll.getYears());
        model.put("type",ll.getLoantype());
        return "loanedit";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String clientno,
                             @RequestParam String clientname, @RequestParam double loanamount,
                             @RequestParam int years, @RequestParam String loantype)
            throws SQLException, ClassNotFoundException {
        String iid = (String) model.get("id");
        Loan ll = new Loan(clientno,clientname, loanamount, years, loantype);
        service1.edit(ll,iid);
        return "redirect:/";
    }
    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id)
            throws SQLException, ClassNotFoundException {
        service1.delete(id);
        model.clear();
        return "redirect:/";
    }


}
