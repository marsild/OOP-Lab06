package it.unibo.oop.lab.collections2;

import java.util.*;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U> Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

	/*
	 * 
	 * [FIELDS]
	 * 
	 * Define any necessary field
	 * 
	 * In order to save the people followed by a user organized in groups, adopt a
	 * generic-type Map:
	 * 
	 * think of what type of keys and values would best suit the requirements
	 */
	Map<String, Set<U>> people;
	/*
	 * [CONSTRUCTORS]
	 * 
	 * 1) Complete the definition of the constructor below, for building a user
	 * participating in a social network, with 4 parameters, initializing:
	 * 
	 * - firstName - lastName - username - age and every other necessary field
	 * 
	 * 2) Define a further constructor where age is defaulted to -1
	 */

	/**
	 * Builds a new {@link SocialNetworkUserImpl}.
	 * 
	 * @param name    the user firstname
	 * @param surname the user lastname
	 * @param userAge user's age
	 * @param user    alias of the user, i.e. the way a user is identified on an
	 *                application
	 */
	public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
		super(name, surname, user, userAge);
		this.people = new HashMap<>();
	}

	public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		this(name, surname, user, -1);
	}

	/*
	 * [METHODS]
	 * 
	 * Implements the methods below
	 */

	@Override
	public boolean addFollowedUser(final String circle, final U user) {
		Set<U> persone = this.people.get(circle);
		if(persone == null) {
			persone = new HashSet<U>();
			this.people.put(circle, persone);
		}
		
		return this.people.get(circle).add(user);
		
	}

	@Override
	public Collection<U> getFollowedUsersInGroup(final String groupName) {
		Collection<U> returnList = this.people.get(groupName);
		if(returnList==null) {
			return Collections.emptyList();
		}
		return new ArrayList<>(returnList);
	}

	@Override
	public List<U> getFollowedUsers() {
		final Set<U> followedUsers = new HashSet<>();
		for(final Set<U> group : this.people.values()) {
			followedUsers.addAll(group);
		}
		return new ArrayList<U>(followedUsers);
	}

}
