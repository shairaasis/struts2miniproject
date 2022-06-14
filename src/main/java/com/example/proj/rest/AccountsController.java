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
    //Return all user records
    public HttpHeaders index() {
        model = map;
        return new DefaultHttpHeaders("index").disableCaching();
    } 

    @Override
    public Object getModel() {
		return (model != null ? model : account);
	}

    //GET accounts/id/ by id
    public String getId() {

        return id;
	}

    //DELETE acount/id/
    //DELETE /accounts/id
	public HttpHeaders destroy() throws Exception {
		System.out.println("DELETE \t /account:" +getId());
		String result = accountRepository.remove(getId());
		return new DefaultHttpHeaders(result);
	}
    //PUT /accounts/id
	public HttpHeaders update() throws Exception {
		account = map.get(getId());
		System.out.println("PUT \t /account" +getId());
		Map<String, Person> accounts = accountRepository.update(getId(), account);
		return new DefaultHttpHeaders("update");
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

    /*POST method, insert data into database*/
    public HttpHeaders create() throws Exception {
        model = accountRepository.save(account); 
        System.out.println(account.toString());
        System.out.println("POST \t /users" +account.getUserId());
        return new DefaultHttpHeaders("create");
    }

}