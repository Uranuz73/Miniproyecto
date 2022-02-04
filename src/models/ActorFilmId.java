package models;
import java.io.Serializable;

/**
 * Composite-id class of Actor_film.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class ActorFilmId implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Pelicula. */
	private Pelicula pelicula;

	/** Actor. */
	private Actor actor;

	/**
	 * Constructor.
	 */
	public ActorFilmId() {
	}

	/**
	 * Set the Pelicula.
	 * 
	 * @param pelicula
	 *            Pelicula
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Get the Pelicula.
	 * 
	 * @return Pelicula
	 */
	public Pelicula getPelicula() {
		return this.pelicula;
	}

	/**
	 * Set the Actor.
	 * 
	 * @param actor
	 *            Actor
	 */
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	/**
	 * Get the Actor.
	 * 
	 * @return Actor
	 */
	public Actor getActor() {
		return this.actor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pelicula == null) ? 0 : pelicula.hashCode());
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
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
		ActorFilmId other = (ActorFilmId) obj;
		if (pelicula == null) {
			if (other.pelicula != null) {
				return false;
			}
		} else if (!pelicula.equals(other.pelicula)) {
			return false;
		}
		if (actor == null) {
			if (other.actor != null) {
				return false;
			}
		} else if (!actor.equals(other.actor)) {
			return false;
		}
		return true;
	}

}
