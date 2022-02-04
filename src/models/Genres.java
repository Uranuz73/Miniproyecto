package models;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of Genres.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Genres implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** idgenre. */
	private String idgenre;

	/** name. */
	private String name;

	/** The set of genre_film. */
	private Set<GenreFilm> genreFilmSet;

	/**
	 * Constructor.
	 */
	public Genres() {
		this.genreFilmSet = new HashSet<GenreFilm>();
	}

	/**
	 * Set the idgenre.
	 * 
	 * @param idgenre
	 *            idgenre
	 */
	public void setIdgenre(String idgenre) {
		this.idgenre = idgenre;
	}

	/**
	 * Get the idgenre.
	 * 
	 * @return idgenre
	 */
	public String getIdgenre() {
		return this.idgenre;
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
	 * Set the set of the genre_film.
	 * 
	 * @param genreFilmSet
	 *            The set of genre_film
	 */
	public void setGenreFilmSet(Set<GenreFilm> genreFilmSet) {
		this.genreFilmSet = genreFilmSet;
	}

	/**
	 * Add the genre_film.
	 * 
	 * @param genreFilm
	 *            genre_film
	 */
	public void addGenreFilm(GenreFilm genreFilm) {
		this.genreFilmSet.add(genreFilm);
	}

	/**
	 * Get the set of the genre_film.
	 * 
	 * @return The set of genre_film
	 */
	public Set<GenreFilm> getGenreFilmSet() {
		return this.genreFilmSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idgenre == null) ? 0 : idgenre.hashCode());
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
		Genres other = (Genres) obj;
		if (idgenre == null) {
			if (other.idgenre != null) {
				return false;
			}
		} else if (!idgenre.equals(other.idgenre)) {
			return false;
		}
		return true;
	}

}
