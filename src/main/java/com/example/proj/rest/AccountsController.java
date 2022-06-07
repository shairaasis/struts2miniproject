package com.example.proj.rest;
import java.sql.SQLException;
import java.util.Map;
import com.example.proj.model.Person;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;

public class AccountsController implements ModelDriven<Object> {
    private static final long serialVersionUID = 1L; 
    private Object model;
    String id;
    Person account = new Person();
    private AccountsRepository accountRepository = new AccountsRepository();
    private static Map<String, Person> map;
    {
        try {
            map = accountRepository.findAllAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    public HttpHeaders index() {
        model = map;
        return new DefaultHttpHeaders("index").disableCaching();
    } 

    @Override
    public Object getModel() {
		return (model != null ? model : account);
	}


    public String getId() {

        return id;
	}
	public void setId(String id) {
		model = accountRepository.getAccountById(id);
		this.id = id;
	}
	public HttpHeaders show() {
		model = accountRepository.getAccountById(getId());
		return new DefaultHttpHeaders("show");
	}

    public void setModel(Object model) {
        this.model = model;
    }
    public Person getAccount() {
        return account;
    }
    public void setAccount(Person account) {
        this.account = account;
    }
    public AccountsRepository getAccountRepository() {
        return accountRepository;
    }
    public void setAccountRepository(AccountsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    /*POST */
    public HttpHeaders create() throws Exception {
        model = accountRepository.save(account); 
        System.out.println(account.toString());
        //System.out.println("POST \t /users" +account.getUserId());
        return new DefaultHttpHeaders("create");
    }

}