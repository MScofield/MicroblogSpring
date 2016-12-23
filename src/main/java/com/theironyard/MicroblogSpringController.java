package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by scofieldservices on 12/20/16.
 * "/"route - should take model and request as arguments
 *          read the username from the session and add it to the model
 *          return the home template
 *
 * "/login"route - take the request and username as arguments
 *          save the username to the session
 *          return a redirect to "/"
 *
 * "/add message"route - tak the message text as an argument
 *          create a message object and add it to the messages arraylist
 *              (id = messages.size() +1)
 *          returns a redirect to "/"
 *
 * "/delete message"route - takes the message id as an argument
 *          remove the message wit the given id 'messages.remove(id-1)
 *          returns a redirect to "/"
 *
 * ArrayList<Message> method to store messages
 *
 */

@Controller
public class MicroblogSpringController {
    ArrayList<Message> messageArray = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session)

    {
       model.addAttribute("name", session.getAttribute("userName"));

       model.addAttribute("message",messageArray);

       return "home";
    }//closing for "/" route

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName)
    {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }//closing for "/login" route

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(Model model, String message)
    {
        Message m = new Message((messageArray.size() +1), message);
        messageArray.add(m);

        return "redirect:/";
    }//closing for "/add-message" route

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(int id)
    {
        messageArray.remove(id-1);
        return "redirect:/";
    }//closing for delete message route

}//closing for public class
