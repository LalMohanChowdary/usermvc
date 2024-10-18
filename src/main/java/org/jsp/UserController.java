package org.jsp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	EntityManager em;
	


	@RequestMapping("/createpage")
	public ModelAndView createPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("create.jsp");
		return mv;
	}

	@RequestMapping("/allusers")
	public ModelAndView viewUsers() {

		javax.persistence.Query q = em.createQuery("from User");
		List<User> users = q.getResultList();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allusers.jsp");
		mv.addObject("users", users);

		return mv;
	}

	@RequestMapping("/save")
	public ModelAndView saveUser(@RequestParam String name, @RequestParam String email, @RequestParam long phone,
			@RequestParam String password) {

		User u = new User();

		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setPassword(password);

		EntityTransaction et = em.getTransaction();
		et.begin();
		User dbuser = em.merge(u);
		et.commit();

		javax.persistence.Query q = em.createQuery("from User");
		List<User> users = q.getResultList();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allusers.jsp");
		mv.addObject("users", users);
		mv.addObject("msg", name + " user Created Sucessfully");

		return mv;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id) {

		User u = em.find(User.class, id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allusers.jsp");

		if (u != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();

			javax.persistence.Query q = em.createQuery("from User");
			List<User> users = q.getResultList();
			mv.addObject("users", users);
			mv.addObject("msg", "UserDeleted Sucessfully");
		} else {

			javax.persistence.Query q = em.createQuery("from User");
			List<User> users = q.getResultList();
			mv.addObject("users", users);
			mv.addObject("msg", " Invalid User ");
		}

		return mv;
	}

	@RequestMapping("/updatepage")
	public ModelAndView updatePage(@RequestParam int id) {

		User user = em.find(User.class, id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("update.jsp");
		mv.addObject("user", user);

		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long phone, @RequestParam String password) {

		User user = em.find(User.class, id);

		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allusers.jsp");
		javax.persistence.Query q = em.createQuery("from User");
		List<User> ul = q.getResultList();

		mv.addObject("users", ul);
		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String sq) {
		javax.persistence.Query q = em.createQuery("from User");

		List<User> ul = q.getResultList();
		ArrayList<User> users = new ArrayList<User>();
		for (User u : ul) {
			if ((u.getId() + "").equalsIgnoreCase(sq) || u.getName().equalsIgnoreCase(sq)
					|| u.getEmail().equalsIgnoreCase(sq) || (u.getPhone() + "").equalsIgnoreCase(sq)
					|| u.getPassword().equalsIgnoreCase(sq)) {
				users.add(u);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("allusers.jsp");
		mv.addObject("users", users);

		return mv;
	}

}
