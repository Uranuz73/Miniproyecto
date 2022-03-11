package models;
import java.io.Serializable;

/**
 * Model class of Actor_film.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class ActorFilm implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Composite-id of Actor_film. */
	private ActorFilmId actorFilmId;

	/** Pelicula. */
	public String peliculaid;

	/** Actor. */
	public String actorid;

	/** actor_name. */
	public String character;

	/** image. */
	public String image;
	
	/** name. */
	public String name;


	/**
	 * Constructor.
	 */

	public ActorFilm(String peliculaid,String actorid,String character,String image,String name) {
	    this.peliculaid = peliculaid;
	    this.actorid = actorid;
	    this.character = character;
	    this.image = image;
	    this.name = name;
	    } 


	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Set the Composite-id of Actor_film.
	 * 
	 * @param actorFilmId
	 *            Composite-id of Actor_film
	 */
	public void setActorFilmId(ActorFilmId actorFilmId) {
		this.actorFilmId = actorFilmId;
	}

	/**
	 * Get the Composite-id of Actor_film.
	 * 
	 * @return Composite-id of Actor_film
	 */
	public ActorFilmId getActorFilmId() {
		return this.actorFilmId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Set the Pelicula.
	 * 
	 * @param pelicula
	 *            Pelicula
	 */
	public void setPelicula(String pelicula) {
		this.peliculaid = pelicula;
	}

	/**
	 * Get the Pelicula.
	 * 
	 * @return Pelicula
	 */
	public String getPelicula() {
		return this.peliculaid;
	}

	/**
	 * Set the Actor.
	 * 
	 * @param actor
	 *            Actor
	 */
	public void setActor(String actor) {
		this.actorid = actor;
	}

	/**
	 * Get the Actor.
	 * 
	 * @return Actor
	 */
	public String getActor() {
		return this.actorid;
	}



	



	@Override
	public String toString() {
		return "ActorFilm [actorFilmId=" + actorFilmId + ", peliculaid=" + peliculaid + ", actorid=" + actorid
				+ ", character=" + character + ", image=" + image + ", name=" + name + "]";
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorFilmId == null) ? 0 : actorFilmId.hashCode());
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
		ActorFilm other = (ActorFilm) obj;
		if (actorFilmId == null) {
			if (other.actorFilmId != null) {
				return false;
			}
		} else if (!actorFilmId.equals(other.actorFilmId)) {
			return false;
		}
		return true;
	}

}
