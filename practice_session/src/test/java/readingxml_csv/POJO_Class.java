package readingxml_csv;

public class POJO_Class implements Comparable<POJO_Class> {

	public POJO_Class() {

	}

	private String name;
	private String age;
	private String city;
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POJO_Class other = (POJO_Class) obj;
		if (age == null) {
			if (other.age != null) {

				return false;
			}
		} else if (!age.equals(other.age)) {

			return false;
		}
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public POJO_Class(String name, String age, String city, String country) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
	}

	public POJO_Class(String[] p) {
		// TODO Auto-generated constructor stub
		super();
		this.name = p[0];
		this.age = p[1];
		this.city = p[2];
		this.country = p[3];
	}

	@Override
	public String toString() {
		return "POJO_Class [name=" + name + ", age=" + age + ", city=" + city + ", country=" + country + "]";
	}

	@Override
	public int compareTo(POJO_Class o) {
		if (this.name.equalsIgnoreCase(o.name)) {
			if (this.age.equalsIgnoreCase(o.age)) {
				if (this.city.equalsIgnoreCase(o.city)) {
					return this.country.compareTo(o.country);
				} else {
					return this.city.compareTo(o.city);
				}
			} else {
				return this.age.compareTo(o.age);
			}
		} else {
			return this.name.compareTo(o.name);
		}
	}

}
