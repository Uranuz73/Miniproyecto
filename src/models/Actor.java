package models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of Actor.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Actor implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** idactor. */
	private String idactor;

	/** name. */
	private String name;

	/** bio. */
	private String bio;

	/** born. */
	private Date born;

	/** country. */
	private String country;

	/** The set of Actor_film. */
	private Set<ActorFilm> actorFilmSet;

	/**
	 * Constructor.
	 */
	public Actor() {
		this.actorFilmSet = new HashSet<ActorFilm>();
	}

	/**
	 * Set the idactor.
	 * 
	 * @param idactor
	 *            idactor
	 */
	public void setIdactor(String idactor) {
		this.idactor = idactor;
	}

	/**
	 * Get the idactor.
	 * 
	 * @return idactor
	 */
	public String getIdactor() {
		return this.idactor;
	}

	/**
	 * Set the name.
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the bio.
	 * 
	 * @param bio
	 *            bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Get the bio.
	 * 
	 * @return bio
	 */
	public String getBio() {
		return this.bio;
	}

	/**
	 * Set the born.
	 * 
	 * @param born
	 *            born
	 */
	public void setBorn(Date born) {
		this.born = born;
	}

	/**
	 * Get the born.
	 * 
	 * @return born
	 */
	public Date getBorn() {
		return this.born;
	}

	/**
	 * Set the country.
	 * 
	 * @param country
	 *            country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the country.
	 * 
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Set the set of the Actor_film.
	 * 
	 * @param actorFilmSet
	 *            The set of Actor_film
	 */
	public void setActorFilmSet(Set<ActorFilm> actorFilmSet) {
		this.actorFilmSet = actorFilmSet;
	}

	/**
	 * Add the Actor_film.
	 * 
	 * @param actorFilm
	 *            Actor_film
	 */
	public void addActorFilm(ActorFilm actorFilm) {
		this.actorFilmSet.add(actorFilm);
	}

	/**
	 * Get the set of the Actor_film.
	 * 
	 * @return The set of Actor_film
	 */
	public Set<ActorFilm> getActorFilmSet() {
		return this.actorFilmSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idactor == null) ? 0 : idactor.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Actor other = (Actor) obj;
		if (idactor == null) {
			if (other.idactor != null) {
				return false;
			}
		} else if (!idactor.equals(other.idactor)) {
			return false;
		}
		return true;
	}

}