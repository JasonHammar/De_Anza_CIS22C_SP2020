
/**
* Movie.java
* @author Jason Hammar
* @author Zyad Khater
* CIS 22C, Lab 5
*/

import java.text.DecimalFormat;

public class Movie implements Comparable<Movie> {
	private String title;
	private String director;
	private int year;
	private double grossMillions;

	/**
	 * Constructor for the Movie class
	 *
	 * @param title    the Movie's title
	 * @param director the Movie's director
	 * @param year     the year the Movie was released
	 * @param gross    the amount grossed over the lifetime of the movie, given in
	 *                 Millions of dollars
	 */
	public Movie(String title, String director, int year, double gross) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.grossMillions = gross;
	}

	/**
	 * Accesses the title of the Movie
	 *
	 * @return the Movie's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Accesses the director of the Movie
	 *
	 * @return the Movie's director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Access the year the Movie was released in theaters
	 *
	 * @return the year the Movie was released
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Access the gross amount earned by the Movie in Millions of dollars
	 *
	 * @return the Movie's gross in Millions
	 */
	public double getGross() {
		return grossMillions;
	}

	/**
	 * Sets the title of the Movie
	 *
	 * @param title the Movie's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the director of the Movie
	 *
	 * @param director the Movie's director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Sets the year the Movie was released
	 *
	 * @param year the year the Movie was released
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Sets the gross amount earned by the Movie in Millions of dolalrs
	 *
	 * @param gross the gross amount in Millions of dollars
	 */
	public void setGross(double gross) {
		grossMillions = gross;
	}

	/**
	 * Creates a String of the Movie information the following format: Title:
	 * <title> Director: <director> Year: <year> Gross in Millions: $<grossMillions>
	 * Note that there should be no <> in the resulting String Also the
	 * grossMillions should be displayed as follows: XXX,XXX.XX
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Title: " + title + "\nDirector: " + director + "\nYear: " + year + "\nGross in Millions: $"
				+ grossMillions + "\n\n";
		return result;
	}

	/**
	 * Determines whether two Movie objects are equal by comparing titles and
	 * directors
	 *
	 * @param otherMovie the second Movie object
	 * @return whether the Movies are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Movie)) {
			return false;
		} else {
			Movie p = (Movie) o;
			return title.equals(p.title) && director.equals(p.director);
		}

	}

	/**
	 * Compares two Movie objects to determine ordering Returns 0 if the two items
	 * are equal Return -1 if this Movie's title comes alphabetically before the
	 * other Movie's title. Returns 1 if the other Movie's title comes
	 * alphabetically before this movie's title If the two movie's titles are the
	 * same, will differentiate by director's name (alphabetical comparison)
	 *
	 * @param the other Movie object to compare to this
	 * @return 0 (same movie), -1 (this movie ordered first) or 1 (the other movie
	 *         ordered first)
	 */
	@Override
	public int compareTo(Movie otherMovie) {
		if (this.equals(otherMovie)) {
			return 0;
		} else if (title.compareTo(otherMovie.title) < 0) {
			return -1;
		} else if (title.compareTo(otherMovie.title) > 0) {
			return 1;
		}
		if (director.compareTo(otherMovie.director) < 0) {
			return -1;
		} else if (director.compareTo(otherMovie.director) > 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * Returns a consistent hash code for each Movie by summing the Unicode values
	 * of each character in the key Key = title + director
	 *
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		String key = title + director;
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}

}
