package models;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of Pelicula.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Pelicula implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private String id;

	/** title. */
	private String title;

	/** year. */
	private Integer year;

	/** duration. */
	private Integer duration;

	/** description. */
	private String description;

	/** poster. */
	private String poster;

	/** valoration. */
	private Float valoration;

	/** director. */
	private String director;

	/** full_title. */
	private String fullTitle;

	/** image. */
	private Blob image;

	/** 255. */
	//private String 255;

	/** release_date. */
	private Date releaseDate;

	/** The set of Actor_film. */
	private Set<ActorFilm> actorFilmSet;

	/** The set of company_pelicula. */
	private Set<CompanyPelicula> companyPeliculaSet;

	/** The set of director_pelicula. */
	private Set<DirectorPelicula> directorPeliculaSet;

	/** The set of genre_film. */
	private Set<GenreFilm> genreFilmSet;

	/** The set of usuario_pelicula. */
	private Set<UsuarioPelicula> usuarioPeliculaSet;

	/**
	 * Constructor.
	 */
	public Pelicula() {
		this.actorFilmSet = new HashSet<ActorFilm>();
		this.companyPeliculaSet = new HashSet<CompanyPelicula>();
		this.directorPeliculaSet = new HashSet<DirectorPelicula>();
		this.genreFilmSet = new HashSet<GenreFilm>();
		this.usuarioPeliculaSet = new HashSet<UsuarioPelicula>();
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Set the title.
	 * 
	 * @param title
	 *            title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the title.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set the year.
	 * 
	 * @param year
	 *            year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Get the year.
	 * 
	 * @return year
	 */
	public Integer getYear() {
		return this.year;
	}

	/**
	 * Set the duration.
	 * 
	 * @param duration
	 *            duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Get the duration.
	 * 
	 * @return duration
	 */
	public Integer getDuration() {
		return this.duration;
	}

	/**
	 * Set the description.
	 * 
	 * @param description
	 *            description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the poster.
	 * 
	 * @param poster
	 *            poster
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**
	 * Get the poster.
	 * 
	 * @return poster
	 */
	public String getPoster() {
		return this.poster;
	}

	/**
	 * Set the valoration.
	 * 
	 * @param valoration
	 *            valoration
	 */
	public void setValoration(Float valoration) {
		this.valoration = valoration;
	}

	/**
	 * Get the valoration.
	 * 
	 * @return valoration
	 */
	public Float getValoration() {
		return this.valoration;
	}

	/**
	 * Set the director.
	 * 
	 * @param director
	 *            director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Get the director.
	 * 
	 * @return director
	 */
	public String getDirector() {
		return this.director;
	}

	/**
	 * Set the full_title.
	 * 
	 * @param fullTitle
	 *            full_title
	 */
	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	/**
	 * Get the full_title.
	 * 
	 * @return full_title
	 */
	public String getFullTitle() {
		return this.fullTitle;
	}

	/**
	 * Set the image.
	 * 
	 * @param image
	 *            image
	 */
	public void setImage(Blob image) {
		this.image = image;
	}

	/**
	 * Get the image.
	 * 
	 * @return image
	 */
	public Blob getImage() {
		return this.image;
	}

	/**
	 * Set the 255.
	 * 
	 * @param 255
	 *            255
	 */
//	public void set255(String 255) {
//		this.255 = 255;
//	}

	/**
	 * Get the 255.
	 * 
	 * @return 255
	 */
//	public String get255() {
//		return this.255;
//	}

	/**
	 * Set the release_date.
	 * 
	 * @param releaseDate
	 *            release_date
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * Get the release_date.
	 * 
	 * @return release_date
	 */
	public Date getReleaseDate() {
		return this.releaseDate;
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
	 * Set the set of the company_pelicula.
	 * 
	 * @param companyPeliculaSet
	 *            The set of company_pelicula
	 */
	public void setCompanyPeliculaSet(Set<CompanyPelicula> companyPeliculaSet) {
		this.companyPeliculaSet = companyPeliculaSet;
	}

	/**
	 * Add the company_pelicula.
	 * 
	 * @param companyPelicula
	 *            company_pelicula
	 */
	public void addCompanyPelicula(CompanyPelicula companyPelicula) {
		this.companyPeliculaSet.add(companyPelicula);
	}

	/**
	 * Get the set of the company_pelicula.
	 * 
	 * @return The set of company_pelicula
	 */
	public Set<CompanyPelicula> getCompanyPeliculaSet() {
		return this.companyPeliculaSet;
	}

	/**
	 * Set the set of the director_pelicula.
	 * 
	 * @param directorPeliculaSet
	 *            The set of director_pelicula
	 */
	public void setDirectorPeliculaSet(Set<DirectorPelicula> directorPeliculaSet) {
		this.directorPeliculaSet = directorPeliculaSet;
	}

	/**
	 * Add the director_pelicula.
	 * 
	 * @param directorPelicula
	 *            director_pelicula
	 */
	public void addDirectorPelicula(DirectorPelicula directorPelicula) {
		this.directorPeliculaSet.add(directorPelicula);
	}

	/**
	 * Get the set of the director_pelicula.
	 * 
	 * @return The set of director_pelicula
	 */
	public Set<DirectorPelicula> getDirectorPeliculaSet() {
		return this.directorPeliculaSet;
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
	 * Set the set of the usuario_pelicula.
	 * 
	 * @param usuarioPeliculaSet
	 *            The set of usuario_pelicula
	 */
	public void setUsuarioPeliculaSet(Set<UsuarioPelicula> usuarioPeliculaSet) {
		this.usuarioPeliculaSet = usuarioPeliculaSet;
	}

	/**
	 * Add the usuario_pelicula.
	 * 
	 * @param usuarioPelicula
	 *            usuario_pelicula
	 */
	public void addUsuarioPelicula(UsuarioPelicula usuarioPelicula) {
		this.usuarioPeliculaSet.add(usuarioPelicula);
	}

	/**
	 * Get the set of the usuario_pelicula.
	 * 
	 * @return The set of usuario_pelicula
	 */
	public Set<UsuarioPelicula> getUsuarioPeliculaSet() {
		return this.usuarioPeliculaSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}