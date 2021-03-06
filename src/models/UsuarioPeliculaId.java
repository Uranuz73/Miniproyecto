package models;
import java.io.Serializable;

/**
 * Composite-id class of usuario_pelicula.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class UsuarioPeliculaId implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** usuario. */
	private Usuario usuario;

	/** Pelicula. */
	private Pelicula pelicula;

	/**
	 * Constructor.
	 */
	public UsuarioPeliculaId() {
	}

	/**
	 * Set the usuario.
	 * 
	 * @param usuario
	 *            usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Get the usuario.
	 * 
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((pelicula == null) ? 0 : pelicula.hashCode());
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
		UsuarioPeliculaId other = (UsuarioPeliculaId) obj;
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		if (pelicula == null) {
			if (other.pelicula != null) {
				return false;
			}
		} else if (!pelicula.equals(other.pelicula)) {
			return false;
		}
		return true;
	}

}
