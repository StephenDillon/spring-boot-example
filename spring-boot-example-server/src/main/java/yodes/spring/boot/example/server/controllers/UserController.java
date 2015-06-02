package yodes.spring.boot.example.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import yodes.spring.boot.example.api.UserApi;
import yodes.spring.boot.example.api.UserDto;
import yodes.spring.boot.example.server.services.UserService;

/**
 * A controller to handle all requests under the /users URL.
 * <p>
 * The @RestController tells spring this is a rest controller and when we component scan spring will create a controller
 * and attempt to map requests if they match the requests URL. We can map specific requests to different methods by the
 * RequestMethod type (ie. Get, Post) or by adding more specific URL mappings
 * <p>
 * Controllers are great places to handle initial validation but avoid adding any business logic here, keeping that in
 * the services layer allows better encapsulation and testing. Controllers generally map to a specific method of serving
 * your resources, rest in this case. Keeping your business logic in your service allows you to easily add another
 * method (Soap, WebSocket ect) without needing to touch your rest layer
 * <p>
 * This type of RestController is one of the simplest to get started, there are more advanced techniques that provide
 * better encapsulating and documentation (hateoas for example)
 * <p>
 * I prefer the term json controller as this might not be 100% restful, but it is simple, clean and behaves as expected
 */
@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

	@Autowired
	private UserService userService;

	/**
	 * This method lists all users and returns it as the body response
	 * 
	 * @return List of users as DTO's
	 */
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<UserDto> list() {
		return userService.list();
	}

	/**
	 * A method to handle a specific GET request for a single resource
	 * 
	 * @param id
	 *            to find
	 * @return Single user resource
	 */
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody UserDto findById(@PathVariable String id) {
		return userService.findById(id);
	}

	/**
	 * A method to handle the create of a resource and we return the created resource
	 * 
	 * @param userDto
	 *            to create
	 * @return created resource with any new fields set ie. id
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody UserDto create(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}

	/**
	 * This is one method of updating a resource. PUT is fairly common but also PATCH or POST to the ID are also used,
	 * each with pros/cons.
	 * <p>
	 * I am using a post update as it is the simplest and most closely represents the replace rather then update i am
	 * doing.
	 * 
	 * @param userDto
	 *            user dto resource to update
	 * @return UserDto as updated
	 */
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody UserDto update(@RequestBody UserDto userDto) {
		return userService.update(userDto);
	}

	/**
	 * This is one method of updating a resource. PUT is fairly common but also PATCH or POST to the ID are also used,
	 * each with pros/cons
	 * 
	 * @param id
	 *            to delete
	 */
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		userService.delete(id);
	}

}
