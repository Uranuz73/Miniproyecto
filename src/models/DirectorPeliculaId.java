package models;
import java.io.Serializable;

/**
 * Composite-id class of director_pelicula.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class DirectorPeliculaId implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Pelicula. */
	private Pelicula pelicula;

	/** Director. */
	private Director director;

	/**
	 * Constructor.
	 */
	public DirectorPeliculaId() {
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
	 * Set the Director.
	 * 
	 * @param director
	 *            Director
	 */
	public void setDirector(Director director) {
		this.director = director;
	}

	/**
	 * Get the Director.
	 * 
	 * @return Director
	 */
	public Director getDirector() {
		return this.director;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pelicula == null) ? 0 : pelicula.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
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
		DirectorPeliculaId other = (DirectorPeliculaId) obj;
		if (pelicula == null) {
			if (other.pelicula != null) {
				return false;
			}
		} else if (!pelicula.equals(other.pelicula)) {
			return false;
		}
		if (director == null) {
			if (other.director != null) {
				return false;
			}
		} else if (!director.equals(other.director)) {
			return false;
		}
		return true;
	}

}
