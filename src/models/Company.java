package models;
import java.io.Serializable;
import java.util.Set;

/**
 * Model class of Company.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Company implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** idcompany. */
	public String idcompany;

	@Override
	public String toString() {
		return "Company [idcompany=" + idcompany + ", name=" + name + "]";
	}

	/** name. */
	public String name;



	/** The set of company_pelicula. */
	private Set<CompanyPelicula> companyPeliculaSet;

	/**
	 * Constructor.
	 */
	public Company() {
		
	}
	
	public Company(String id,String name) {
		this.idcompany = id;
		this.name = name;
		
	}

	/**
	 * Set the idcompany.
	 * 
	 * @param idcompany
	 *            idcompany
	 */
	public void setIdcompany(String idcompany) {
		this.idcompany = idcompany;
	}

	/**
	 * Get the idcompany.
	 * 
	 * @return idcompany
	 */
	public String getIdcompany() {
		return this.idcompany;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcompany == null) ? 0 : idcompany.hashCode());
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
		Company other = (Company) obj;
		if (idcompany == null) {
			if (other.idcompany != null) {
				return false;
			}
		} else if (!idcompany.equals(other.idcompany)) {
			return false;
		}
		return true;
	}

}
