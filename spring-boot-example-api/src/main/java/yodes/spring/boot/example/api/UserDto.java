package yodes.spring.boot.example.api;

/**
 * DTO class to represent a user
 * <p>
 * Note the package name directs us to the project and exact subproject/package,
 * making debugging much easier. The idea is this package represents your api
 * contract and changes here directly impact your users
 * <p>
 * Dto stands for Data Transfer Object and is a good way to encapsulate how this
 * resource is saved and documented, allowing you to easily swap how your
 * resource is stored without any changes to your API. This is great for
 * security and allows you to quickly evolve your service without impacting
 * users
 */
public class UserDto {

	/**
	 * Unique identifier for the user
	 */
	private String id;

	/**
	 * Name of the user
	 */
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
