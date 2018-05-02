package com.phonebook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import com.phonebook.service.ContactService;
import com.phonebook.service.UserService;


/**
 * Product controller.
 */
@Controller
public class ContactController {
	List<Contact> list = null;
	Iterable<Contact>iter = null;
	@Autowired
    private ContactService contactService;
    @Autowired
	private UserService userService;

   /* @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }*/

    /**
     * List all contacts.
     *act
     * @param model
     * @return
     */
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String list(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByLogin(auth.getName());
    	list = contactService.getAllUserContacts(user.getId());
    	model.addAttribute("contacts", list);
    
        return "contacts";
    }
    
    /**
     * View a specific contact by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("contact/{id}")
    public String showContact(@PathVariable Integer id, Model model) {
        model.addAttribute("cont", contactService.getContactById(id));
        return "contactshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("contact/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "contactform";
    }

    /**
     * New contact.
     *
     * @param model
     * @return
     */
    @RequestMapping("contact/new")
    public String newContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contactform";
    }

 
    /**
     * Save product to database.
     *
     * @param contract
     * @return
     */
    @RequestMapping(value = "contact", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute("contact")Contact contact,BindingResult bindingResult
) {
    	 if(bindingResult.hasErrors()) { return "contactform"; }
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByLogin(auth.getName());
		contact.setUserId(user.getId());
    	contactService.saveContact(contact);
    	
        return "redirect:/contacts "  ;
    }

    /**
     * Delete contact by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("contact/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	contactService.deleteContact(id);
        return "redirect:/contacts";
    }
    
    @RequestMapping("contact/search")
    public String searchContact(Model model) {
    	
    		model.addAttribute("contact", new  Contact());
    		return "search";
    		    
    }
    
    @RequestMapping(value = "/searchResult", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute("contact")Contact contact, 
   		 ModelMap model) {
    	
    	 list= contactService.findBySurname(contact.getSurname());
    	    model.addAttribute("contacts", list);
    	    return "contacts";    
    	}

}
