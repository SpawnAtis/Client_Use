package by.Pokosenko.Message;

import by.Pokosenko.Utils.Actions;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Message implements Serializable {

    //private String login;
    private String message;
    private Actions action;
    //private Date time;

    //Конструктор, которым будет пользоваться клиент
    public Message(Actions action,String message){
       // this.login = login;
        this.message = message;
        //this.time = java.util.Calendar.getInstance().getTime();
        this.action=action;
    }

    public Message(Actions action)
    {
        this.action=action;
    }


    /*//Конструктор, которым будет пользоваться сервер
    public Message(String login, String message, String[] users){
        this.login = login;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
    }*/


   /* public String getLogin() {
        return this.login;
    }*/

    public String getMessage() {
        return this.message;
    }

    public Actions getAction() {
        return this.action;
    }

    /*public String getDate(){
        Time tm = new Time(this.time.getTime());
        return tm.toString();
    }*/
}
