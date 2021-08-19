package com.example.Final3275Project;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class LoanService {

    private static List<Loan> todos = new ArrayList<Loan>();
    //private static int todoCount = 2;
    static {
        todos.add(new Loan("1111", "Reshma", 10000, 2, "Personal"));
        todos.add(new Loan("1112", "Hari", 2000000, 5, "Business"));
    }
    public void initialadd(){
        todos.add(new Loan("1111", "Reshma", 10000, 2, "Personal"));
        todos.add(new Loan("1112", "Hari", 2000000, 5, "Business"));
    }
    public List<Loan> retrieveTodos() {
        List<Loan> filteredTodos = new ArrayList<Loan>();
        for (Loan todo : todos) {
            filteredTodos.add(todo);
        }
        return filteredTodos;
    }
    public void addTodo(String clientno, String clientname, double loanamount, int years, String loantype) {
        todos.add(new Loan(clientno, clientname,loanamount, years, loantype));
    }
    public void deleteTodo(String id) {
        for (int i = 0; i < todos.size(); i++) {
            if(id.equals(todos.get(i).getClientno())) {
                todos.remove(i);
                break;
            }
        }
    }
    public Loan retrieve(String id){
        for(Loan todo: todos){
            if(todo.getClientno().equals(id)){
                return todo;
            }
        }
        return null;
    }
    public void update(Loan todo){
        todos.remove(todo);
        todos.add(todo);
    }

}
